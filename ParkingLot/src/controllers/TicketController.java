package controllers;

import dtos.GenerateTicketRequestDTO;
import dtos.GenerateTicketResponseDTO;
import dtos.ResponseStatus;
import exceptions.NoParkingSlotAvailableException;
import models.Gate;
import models.Operator;
import models.Ticket;
import models.Vehicle;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO request){
        GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();

        try {
            Ticket ticket = ticketService.generateTicket(
                    request.getGateId(), request.getVehicleNumber(), request.getVehicleType()
            );
            responseDTO.setTicket(ticket);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(NoParkingSlotAvailableException ex){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(ex.getMessage());
        }

        return responseDTO;
    }
}

// get gate
// either get vehicle from db or register
// assigning the parking slot

// ts, gs and vs from the tc itself
// ts and then ts calls gs and vs
