package com.example.gig.demo.user;


import com.example.gig.demo.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1")
public class UsersController {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @GetMapping("/users")
    public HashMap<String,Iterable<User>> all() {
        HashMap result= new HashMap<>();
        result.put("users",usersRepository.findAll());
        return result;
    }
    @PostMapping("/users")
    public User addOneUser(@RequestBody HashMap< String,String> input) {
        User finals= new User();
        finals.setName(input.get("name"));
        finals.setPassword(input.get("password"));


        return usersRepository.save(finals);
    }


    @PostMapping("/users/login")
    public Long userLogin(@RequestBody HashMap<String, String>input){
        String email=input.get("name");

        String s = input.get("password");

        final Boolean[] authenticated = {false};
        final Long[] iid = {null};

        usersRepository.findAll().forEach(user->{
            if(user.getName().equals(email)){
                System.out.println(user.getPassword());
                System.out.println(s);
                if(user.getPassword().equals(s))
                {
                    authenticated[0] =true;
                    iid[0] =user.getId();


                }

            }
        });
if(iid[0]==null)
    return new Long(-1);
else
        return new Long(iid[0]);
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable String user_id){
        User user=usersRepository.findById(Long.parseLong(user_id))
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", user_id));
        usersRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}