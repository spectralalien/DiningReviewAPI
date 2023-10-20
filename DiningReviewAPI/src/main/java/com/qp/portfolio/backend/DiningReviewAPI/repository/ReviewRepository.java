package com.qp.portfolio.backend.DiningReviewAPI.repository;

import com.qp.portfolio.backend.DiningReviewAPI.model.Review;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    ArrayList<Review> findByStatus(String status);
}
