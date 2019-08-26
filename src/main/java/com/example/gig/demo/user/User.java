package com.example.gig.demo.user;



import lombok.Data;

import javax.persistence.*;

    @Entity
    @Data
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column
        private String name;


        @Column
        private String password;

    }

