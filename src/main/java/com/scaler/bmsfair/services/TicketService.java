package com.scaler.bmsfair.services;

import com.scaler.bmsfair.exceptions.ShowSeatNotAvailableException;
import com.scaler.bmsfair.exceptions.UserNotFoundException;
import com.scaler.bmsfair.models.ShowSeat;
import com.scaler.bmsfair.models.Ticket;
import com.scaler.bmsfair.models.User;
import com.scaler.bmsfair.models.enums.SeatStatus;
import com.scaler.bmsfair.repositories.ShowSeatRepository;
import com.scaler.bmsfair.repositories.TicketRepository;
import com.scaler.bmsfair.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    private ShowSeatRepository showSeatRepository;

    private UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, ShowSeatRepository showSeatRepository, UserRepository userRepository){
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
    }

    public Ticket bookTicket(List<Long> showSeatIds, Long userId) throws ShowSeatNotAvailableException, UserNotFoundException {

        //Algorithm
        //1. get all the show seats from repository
        //2. check if they are available, [availabble, locked 10 mins agao]
        //2.1 not available, return with exception
        //2.2 if available, set status to locked
        //3. Return the ticket(After this send to payment gateway)

        List<ShowSeat> showSeats = showSeatRepository.findByListOfIds(showSeatIds);

        for(ShowSeat showSeat: showSeats){
            if(isShowSeatAvailable(showSeat)){
                throw new ShowSeatNotAvailableException("One of the selected seats is not available."
                        + showSeat.getSeat().getNumber());
            }
        }
        List<ShowSeat> updatedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setLockedAt(new Date());
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            ShowSeat updatedShowSeat = showSeatRepository.save(showSeat);
            updatedShowSeats.add(updatedShowSeat);
        }

        Optional<User> bookedBy = userRepository.findById(userId);
        if(bookedBy.isEmpty()){
            throw new UserNotFoundException("User Not found this id");
        }
        Ticket ticket = new Ticket();
        ticket.setBookedAt(new Date());
        ticket.setBookedBy(bookedBy.get());

        ticket.setShowSeats(updatedShowSeats);
        Ticket saveTicket = ticketRepository.save(ticket);



        return null;
    }

    private boolean isShowSeatAvailable(ShowSeat showSeat){
        if(showSeat.getSeatStatus().equals((SeatStatus.AVAILABLE))){
           return true;
        }else if(showSeat.getSeatStatus().equals(SeatStatus.LOCKED)){
           long lockedAt = showSeat.getLockedAt().getTime();
           long currentTime = System.currentTimeMillis();
           long duration = (currentTime - lockedAt) / 1000; //converting to seconds
            if(duration > 600){ // more than 10 mins
                return true;
            }
        }
        return false;
    }

}
