package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Auditorium extends BaseModel{
    private String name;
    private List<Seat> seats;
    private List<Show> shows;
    private List<Feature> features;

}
