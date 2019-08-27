package com.example.gig.demo.review;


import com.example.gig.demo.job.Job;
import com.example.gig.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

    @Entity
    @Data
    @Table(name = "reviews")
    public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
@Column (length=65536)
private String comment;
        @Column
        private int rating;
        @Column
        private boolean mod;
        // This is a many-to-one relationship, it's not optional
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        // This is a join column that is non-nullable, called "user_id"
        @JoinColumn(name = "userId", nullable = false)
        // On delete, make sure that everything related is also deleted
        @OnDelete(action = OnDeleteAction.CASCADE)
        // Don't show this data when calling for statuses via an API call
        @JsonIgnore
        private User user;
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        // This is a join column that is non-nullable, called "user_id"
        @JoinColumn(name = "jobId", nullable = false)
        // On delete, make sure that everything related is also deleted
        @OnDelete(action = OnDeleteAction.CASCADE)
        // Don't show this data when calling for statuses via an API call
        @JsonIgnore
        private Job job;

        public Review() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public boolean isMod() {
            return mod;
        }

        public void setMod(boolean mod) {
            this.mod = mod;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Job getJob() {
            return job;
        }

        public void setJob(Job job) {
            this.job = job;
        }
    }
