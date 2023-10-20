package com.qp.portfolio.backend.DiningReviewAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qp.portfolio.backend.DiningReviewAPI.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByDisplayName(String displayName);
    User findByUserID(long id);
}
