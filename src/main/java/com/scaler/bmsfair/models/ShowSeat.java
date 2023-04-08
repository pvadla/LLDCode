package com.scaler.bmsfair.models;

import com.scaler.bmsfair.models.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    //ShowSeat : show
    //1 : 1
    //m  : 1
    @ManyToOne
    private Show show;

    //Showseat : seat
    //1 : 1
    //m : 1
    @ManyToOne
    private Seat seat;

    private Date lockedAt;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
