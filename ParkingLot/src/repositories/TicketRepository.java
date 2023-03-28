package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long, Ticket>  tickets = new HashMap<>();
    private Long autoSequenceId = 0L;

    public Ticket save(Ticket ticket){
        autoSequenceId++;
        ticket.setId(autoSequenceId);
        tickets.put(autoSequenceId, ticket);
        return ticket;
    }
}
