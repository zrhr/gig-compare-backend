package com.example.gig.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1")
public class UsersController {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/users")
    public User addOneUser(@RequestBody User user) {
        System.out.println(user);
        return usersRepository.save(user);
    }

    @PostMapping("/users/login")
    public User userLogin(@RequestBody HashMap<String, String> creds) {
        User user = usersRepository.findByName(creds.get("name"));
        return user;
    }
}