package com.qp.portfolio.backend.DiningReviewAPI.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qp.portfolio.backend.DiningReviewAPI.model.AdminApproval;
import com.qp.portfolio.backend.DiningReviewAPI.model.Review;
import com.qp.portfolio.backend.DiningReviewAPI.repository.ReviewRepository;
import  com.qp.portfolio.backend.DiningReviewAPI.repository.UserRepository;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewRepository instancerepo;
    @Autowired
    private UserRepository userrepo;

        @PostMapping("/submit")
        public ResponseEntity<Review> newReview(@RequestBody Review newReview){
            String userName = newReview.getDisplayName();
            if(userrepo.findByDisplayName(userName)== null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            newReview.setStatus("submitted");
            newReview.setId(null);
           Review review = instancerepo.save(newReview);
           return ResponseEntity.ok(review);
        }

        @GetMapping("/status/{filter}")
        public ResponseEntity<ArrayList<Review>> getReviewsByStatus(@PathVariable String filter){
            ArrayList<Review> filteredReviews = instancerepo.findByStatus(filter);
            return ResponseEntity.ok(filteredReviews);
        }

        @PostMapping("/admin/{id}")
        public ResponseEntity<Review> handleReview(@PathVariable long id, @RequestBody AdminApproval approval){
            Review review = instancerepo.findById(id).get();  
            review.setStatus(approval.getStatus());
            
            instancerepo.save(review);
            return ResponseEntity.ok(review);
        }
}
