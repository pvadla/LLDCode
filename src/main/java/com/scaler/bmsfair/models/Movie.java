package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.Language;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private String description;
    private Language language;
    private Actor actors;
}
