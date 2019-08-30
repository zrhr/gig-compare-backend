package com.example.gig.demo.review;


import com.example.gig.demo.ResourceNotFoundException;
import com.example.gig.demo.job.JobsRepository;
import com.example.gig.demo.user.UsersRepository;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager.*;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

    @RestController
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/api/v1")
    public class ReviewController {

        @Autowired
        private final ReviewsRepository reviewsRepository;
        private final UsersRepository usersRepository;
        private final JobsRepository jobsRepository;


        public ReviewController(ReviewsRepository reviewsRepository, JobsRepository jobsRepository, UsersRepository usersRepository) {
            this.reviewsRepository = reviewsRepository;
            this.jobsRepository = jobsRepository;
            this.usersRepository = usersRepository;
        }
        @GetMapping("/reviews")
        public List<Review> all() {

            return this.reviewsRepository.findAll();

        }
        @GetMapping("/reviews/{user_id}/{job_id}")
        public List<Review> userJob(@PathVariable String user_id, @PathVariable String job_id) {

        return reviewsRepository.findByUserAndJob( Long.parseLong(user_id),Long.parseLong( job_id));
        }
        @GetMapping("/reviews/user/{user_id}")
        public List<Review> userOnly(@PathVariable String user_id) {

            return reviewsRepository.findByUser( Long.parseLong(user_id));
        }
        @GetMapping("/reviews/job/{job_id}")
        public List<Review> jobOnly( @PathVariable String job_id) {

            return reviewsRepository.findByJob( Long.parseLong( job_id));
        }
        @GetMapping("/rating/{job_id}")
        public float averageRating(@PathVariable String job_id){
            return this.reviewsRepository.findAverageRating(Long.parseLong(job_id));
        }
        @PatchMapping("/reviews/{review_id}")
        public Review updateReview(@PathVariable String review_id,
                                   @RequestBody Review reviewNew){
            Review reviewOld = reviewsRepository.findById(Long.parseLong(review_id))
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", review_id));
            reviewOld.setComment(reviewNew.getComment());
            reviewOld.setRating(reviewNew.getRating());

            return reviewsRepository.save(reviewOld);

        }

        @PostMapping("/reviews/{user_id}/{job_id}")
        public Optional<Review> addOneAccount(@PathVariable long user_id, @PathVariable Long job_id,@RequestBody Review newComment) {
             if(newComment.getComment()==null)
                 return Optional.empty();
            else {
                 newComment.setUser(usersRepository.findById(user_id).get());
                 newComment.setJob(jobsRepository.findById(job_id).get());
                 return Optional.of(reviewsRepository.save(newComment));
             }

        }
        @DeleteMapping("/reviews/{review_id}")
        public ResponseEntity<?> deleteUser(@PathVariable String review_id){
            Review user=reviewsRepository.findById(Long.parseLong(review_id))
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", review_id));
            reviewsRepository.delete(user);
            return ResponseEntity.ok().build();
        }
    }
