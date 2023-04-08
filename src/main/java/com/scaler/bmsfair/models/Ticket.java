package com.scaler.bmsfair.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private Date bookedAt;

    //Ticket : user
    //1 : 1
    //m  : 1
    @ManyToOne
    private User bookedBy;
    private int amount;

    //ticket : showseat
    //1 : m
    //1 : 1
    @OneToMany
    private List<ShowSeat> showSeats;




}
