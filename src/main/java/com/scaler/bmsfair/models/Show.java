package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Feature;

import java.util.Date;
import java.util.List;

public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    private Movie movie;
    private List<Feature> featuresRequired;


}
