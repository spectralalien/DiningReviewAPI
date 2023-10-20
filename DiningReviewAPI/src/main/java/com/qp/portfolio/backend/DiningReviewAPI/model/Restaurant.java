package com.qp.portfolio.backend.DiningReviewAPI.model;

import lombok.*;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


enum Category{Thai, Chinese, Vietnamese, Indian, Fusion, Bistro, Mexican, Italian, Pizza, Cuban, Cajun,
             Vegetarian, Dinner, Lunch, Coffee, Breakfast, Pastries}
@Entity
@Table(name= "Restaurants", uniqueConstraints = @UniqueConstraint(columnNames = {"Name", "ZIP Code"}))
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @JsonIgnore
    private Long id;
    @Column(name="Name")
    @Getter @Setter
    private String name;
    @Column(name="ZIP Code")
    @Getter @Setter
    private long zip;

    @OneToMany(mappedBy = "Restaurant", cascade = CascadeType.ALL)
    private ArrayList<Review> reviewList;

    @ElementCollection
    @Getter @Setter
    private ArrayList<Category> categoryTags;
    @Getter @Setter
    @Column(name="Peanut Score")
    private Double peanutScore = null;
    @Getter @Setter
    @Column(name="Egg Score")
    private Double eggScore = null;
    @Getter @Setter
    @Column(name="Dairy Score")
    private Double dairyScore = null;

/*     private int peanutCount = 0 , eggCount = 0, dairyCount = 0;
    private int peanutTot = 0 , eggTot = 0, dairyTot = 0; */
     

    
    public double calculateAverageScore() {
        return (peanutScore + eggScore + dairyScore) / 3;
    }

    public ArrayList<Review> getReviewList() {
        return reviewList;
    }

/*     public void calculateScores()
    {
        for (Review review : reviewList) {
            if()
             += review.getPeanutScore().getNumeric();
            count++;
        }
    } */
}
