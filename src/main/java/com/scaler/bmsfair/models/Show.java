package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    private Movie movie;
    private List<Feature> featuresRequired;


}
