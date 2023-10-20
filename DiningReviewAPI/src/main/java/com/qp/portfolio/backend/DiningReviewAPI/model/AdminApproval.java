package com.qp.portfolio.backend.DiningReviewAPI.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

 enum Status{submitted,Approved,Rejected}

@NoArgsConstructor 
public class AdminApproval {
    @NonNull
    @Setter
    private Status status;

    public String getStatus(){
        return this.status.name();
    }



    public AdminApproval(String newStatus){
        this.status = Status.valueOf(newStatus.toString()) ;
    }
}
