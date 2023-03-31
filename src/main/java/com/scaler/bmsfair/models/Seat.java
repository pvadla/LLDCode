package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String number;
    private int row;
    private int col;
    private SeatType seatType;


}
