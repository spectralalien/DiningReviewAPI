package com.qp.portfolio.backend.DiningReviewAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qp.portfolio.backend.DiningReviewAPI.model.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
  List<Restaurant> findAllByZip (long zipCode);
}
