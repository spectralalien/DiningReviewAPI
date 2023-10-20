package com.qp.portfolio.backend.DiningReviewAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qp.portfolio.backend.DiningReviewAPI.model.User;
import com.qp.portfolio.backend.DiningReviewAPI.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository instancerepo;

        @PostMapping("/new")
        
        public ResponseEntity<User> newUser(@RequestBody User newUser){
           newUser.setUserID(null);
           User user = instancerepo.save(newUser);
           if(user != null){
           return ResponseEntity.ok(user);
           }
           else
           {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
           }
        }

        @GetMapping("/{name}")
        public ResponseEntity<User> getUser(@PathVariable String name){
            User user = instancerepo.findByDisplayName(name);
            if(user != null){
           return ResponseEntity.ok(user);
           }
           else
           {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           }
        }

        @PutMapping("/save/{name}")
        public ResponseEntity<User> updateUser(@PathVariable String name,@RequestBody User userDetails) {
        User user = instancerepo.findByDisplayName(name);

        user.setCity(userDetails.getCity());
        user.setState(userDetails.getState());
        user.setZip(userDetails.getZip());
        user.setPeanuts(userDetails.getPeanuts());
        user.setEggs(userDetails.getEggs());
        user.setDairy(userDetails.getDairy());

        instancerepo.save(user);

        return ResponseEntity.ok(user);
        }
        
}
