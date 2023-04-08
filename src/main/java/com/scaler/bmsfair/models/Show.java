package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;

    //Show : movie
    //1 : 1
    //m  : 1
    @ManyToOne
    private Movie movie;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> featuresRequired;


}
