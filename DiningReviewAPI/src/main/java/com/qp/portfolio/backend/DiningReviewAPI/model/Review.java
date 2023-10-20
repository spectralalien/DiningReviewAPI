package com.qp.portfolio.backend.DiningReviewAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

enum Rating{ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5);
    private final int numeric;
    private Rating (int num){
        this.numeric = num;
    }
    public int getNumeric(){
        return this.numeric;
    }
}

@Entity
@Table(name="Reviews", uniqueConstraints = @UniqueConstraint(columnNames = {"Display Name", "Restaurant ID"}))
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Setter
     @JsonIgnore
    private Long id;
    @NonNull
    @Column(name="Approval Status")
    @Getter @Setter
    String status;
    @NonNull
    @Column(name="Display Name")
    @Getter @Setter
    private String displayName;
    @NonNull
    @Column(name="Restaurant ID")
    @Getter @Setter
    private Long restaurantId;

    @ManyToOne
    @JoinColumn(name = "Restaurant ID")
    private Restaurant restaurant;

    @Getter @Setter
    @Column(name="Peanut SCore")
    private Rating peanutScore;
    @Getter @Setter
    @Column(name="Egg Score")
    private Rating eggScore;
    @Getter @Setter
    @Column(name="Dairy Score")
    private Rating dairyScore;
    @Getter @Setter
    @Column(name="Commentary")
    private String commentary;

/* 
    public void updateRestaurantScores() {
            restaurant.calculateScores();
    } */

}
