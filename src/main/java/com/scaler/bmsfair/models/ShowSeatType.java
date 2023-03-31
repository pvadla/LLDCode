package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int price;


}
