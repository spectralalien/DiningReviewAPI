package com.qp.portfolio.backend.DiningReviewAPI.model;
import lombok.*;
import java.util.ArrayList;

enum Category{Thai, Chinese, Vietnamese, Indian, Fusion, Bistro, Mexican, Italian, Pizza, Cuban, Cajun, Vegetarian, Dinner, Lunch, Coffee}
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @NonNull
    private Long id;
    private String name;
    @Getter
    private ArrayList<Category> categoryTags;
    @Getter @Setter
    private Double peanutScore = null;
    @Getter @Setter
    private Double eggScore = null;
    @Getter @Setter
    private Double dairyScore = null;
     

    
    public double calculateAverageScore() {
        return (peanutScore + eggScore + dairyScore) / 3;
    }
}
