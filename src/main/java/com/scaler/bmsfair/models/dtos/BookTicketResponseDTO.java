package com.scaler.bmsfair.models.dtos;

import com.scaler.bmsfair.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private ResponseStatus responseStatus;
    private Ticket ticket;
}
