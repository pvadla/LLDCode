package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Feature;

import java.util.List;

public class Auditorium extends BaseModel{
    private String name;
    private List<Seat> seats;
    private List<Show> shows;
    private List<Feature> features;

}
