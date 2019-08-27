package com.example.gig.demo.job;


import com.example.gig.demo.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("api/v1")
    public class JobsController {

        @Autowired
        private final JobsRepository jobsRepository;

        public JobsController(JobsRepository jobsRepository) {
            this.jobsRepository = jobsRepository;
        }
        @GetMapping("/gigs")
        public List<Job> all() {
            System.out.println(this.jobsRepository.findAll().get(0).toString());
            return this.jobsRepository.findAll();

        }@GetMapping("/gigs/{id}")
    public Optional<Job> getOne(@PathVariable String id) {

        return this.jobsRepository.findById(Long.parseLong(id));

    }

        @PostMapping("/gigs")
        public Job addOneGig(@RequestBody Job user) {
            System.out.println(user);
            return jobsRepository.save(user);
        }
    @DeleteMapping("/gigs/{gig_id}")
    public ResponseEntity<?> deleteUser(@PathVariable String user_id){
        Job user=jobsRepository.findById(Long.parseLong(user_id))
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", user_id));
        jobsRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}
