package com.scaler.bmsfair.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStatus {
    private String message;
    private StatusCode statusCode;

}
