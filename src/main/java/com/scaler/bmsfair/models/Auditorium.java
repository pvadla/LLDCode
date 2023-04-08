package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;

    //A : S
    //1 : m
    //1 : 1
    //1 : m
    @OneToMany
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;

    //Audi : shows
    //1 : m
    //1 : 1
    //1 : m
    @OneToMany
    private List<Show> shows;


    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

}
