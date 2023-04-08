package com.scaler.bmsfair.controllers;

import com.scaler.bmsfair.models.Ticket;
import com.scaler.bmsfair.models.dtos.BookTicketRequestDTO;
import com.scaler.bmsfair.models.dtos.BookTicketResponseDTO;
import com.scaler.bmsfair.models.dtos.ResponseStatus;
import com.scaler.bmsfair.models.dtos.StatusCode;
import com.scaler.bmsfair.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    //Spring will automatically use topological sort for creating objects
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO){
        BookTicketResponseDTO responseDTO = null;
        ResponseStatus rs= new ResponseStatus();
        try{
            Ticket ticket = ticketService.bookTicket
                    (bookTicketRequestDTO.getShowSeatIds(), bookTicketRequestDTO.getUserId());
            rs.setStatusCode(StatusCode.SUCCESS);
            responseDTO.setTicket(ticket);
            responseDTO.setResponseStatus(rs);
        }catch (Exception ex){
            rs.setMessage(ex.getMessage());
            rs.setStatusCode(StatusCode.FAILURE);
            responseDTO.setResponseStatus(rs);

        }

        return responseDTO;
    }
}
