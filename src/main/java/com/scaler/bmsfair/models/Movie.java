package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Language;

public class Movie extends BaseModel{
    private String name;
    private String description;
    private Language language;
    private Actor actors;
}
