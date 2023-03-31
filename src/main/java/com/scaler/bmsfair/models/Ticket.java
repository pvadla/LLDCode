package com.scaler.bmsfair.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel{
    private Date bookedAt;
    private User bookedBy;
    private int amount;
    private List<ShowSeat> showSeats;
    private Auditorium auditorium;





}
