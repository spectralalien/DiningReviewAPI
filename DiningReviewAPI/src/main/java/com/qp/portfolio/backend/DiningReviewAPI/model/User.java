package com.qp.portfolio.backend.DiningReviewAPI.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Entity
@Table(name="Users", uniqueConstraints = @UniqueConstraint(columnNames="Display Name"))
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @JsonIgnore
    private Long userID;
    @NonNull
    @Getter
    @Column(name="Display Name")
    private String displayName;
    @Getter @Setter
    @Column(name="City")
    private String city;
    @Getter @Setter
    @Column(name="State")
    private String state;
    @Getter @Setter
    @Column(name="ZIP Code")
    private long zip;
    
    @Column(name="Peanut Allergies")
    @Getter @Setter
    private Boolean peanuts;
    
    @Column(name="Egg Allergies")
    @Getter @Setter
    private Boolean eggs;
    
    @Column(name="Dairy Allergies")
    @Getter @Setter
    private Boolean dairy;

}
