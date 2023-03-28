import controllers.TicketController;
import dtos.GenerateTicketRequestDTO;
import dtos.GenerateTicketResponseDTO;
import models.enums.VehicleType;
import repositories.ParkingLotRepository;
import repositories.ParkingSlotRepository;
import repositories.TicketRepository;
import services.GateService;
import services.TicketService;
import services.VehicleService;
import services.strategies.slotAllocationStrategies.FirstSlotAvailableStrategy;
import services.strategies.slotAllocationStrategies.SlotAllocationStrategy;

public class Client {
    public static void main(String[] args) {


        GateService gs = new GateService();
        VehicleService vs = new VehicleService();

        ParkingLotRepository plr = new ParkingLotRepository();
        ParkingSlotRepository pslr = new ParkingSlotRepository();

        SlotAllocationStrategy sas = new FirstSlotAvailableStrategy(plr, pslr);
        TicketRepository tr = new TicketRepository();

        TicketService ts = new TicketService(gs, vs, sas, tr);
        TicketController  tc = new TicketController(ts);

        // Request -
        GenerateTicketRequestDTO request = new GenerateTicketRequestDTO();
        request.setGateId(12L);
        request.setVehicleNumber("HR03 1295");
        request.setVehicleType(VehicleType.MEDIUM);

        GenerateTicketResponseDTO responseDTO = tc.generateTicket(request);

    }
}

// Requirement:
//  1. Generate Ticket workflow

// Way to think
// 1. which model is it about? Ticket
// 2. TicketController, TicketService, TicketRepository


// Should TickerController methods take models as parameters and return types?
// 1. DB models should not be exposed
// 2. Try to take a single parameter in controller, so that for new parameters the code doesn't break in future
// 3.