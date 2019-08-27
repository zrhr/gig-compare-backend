package com.example.gig.demo.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    @Query(value="Select * from reviews  where user_id=?1 and job_id=?2",nativeQuery=true)
    List<Review>
    findByUserAndJob(Long user_id, Long job_id);
    @Query (value="Select AVG(rating) from reviews  where job_id=?1", nativeQuery = true)
    Float findAverageRating(Long job_id);
}
