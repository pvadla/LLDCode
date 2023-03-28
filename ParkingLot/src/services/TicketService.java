package services;

import exceptions.NoParkingSlotAvailableException;
import models.Gate;
import models.ParkingSlot;
import models.Ticket;
import models.Vehicle;
import models.enums.VehicleType;
import repositories.TicketRepository;
import services.strategies.slotAllocationStrategies.SlotAllocationStrategy;

import java.util.Date;

public class TicketService {
    private GateService gateService;
    private VehicleService vehicleService;

    private SlotAllocationStrategy slotAllocationStrategy;
    private TicketRepository ticketRepository;

    public TicketService(GateService gateService, VehicleService vehicleService, SlotAllocationStrategy slotAllocationStrategy, TicketRepository ticketRepository){
        this.gateService = gateService;
        this.vehicleService = vehicleService;
        this.slotAllocationStrategy = slotAllocationStrategy;
        this.ticketRepository = ticketRepository;
    }


    // cannot pass the controller's dto -> because it might be used by other controllers using other dto's also
    // but it is better if it takes one parameter (an options object), here we are breaking this rule
    // assuming time in interview is short
    public Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) throws NoParkingSlotAvailableException {
        Gate gate = gateService.getGateById(gateId);
        Vehicle vehicle = vehicleService.getVehicleByVehicleNumber(vehicleNumber);
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        ParkingSlot assignedSlot = slotAllocationStrategy.assignSlot(gate, vehicle.getVehicleType());
        if(assignedSlot == null){
            throw new NoParkingSlotAvailableException("No parking slot available");
        }

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setVehicle(vehicle);
        ticket.setParkingSlot(assignedSlot);

        // BUG -> Update the assignSlot status to occupied

        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;
    }
}
