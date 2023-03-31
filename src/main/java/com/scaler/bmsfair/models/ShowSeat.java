package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.SeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private SeatStatus seatStatus;
}
