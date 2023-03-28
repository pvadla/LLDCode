package services.strategies.slotAllocationStrategies;

import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import models.enums.ParkingSlotStatus;
import models.enums.VehicleType;
import repositories.ParkingLotRepository;
import repositories.ParkingSlotRepository;

import java.util.List;

public class FirstSlotAvailableStrategy implements SlotAllocationStrategy {
    private ParkingLotRepository parkingLotRepository;
    private ParkingSlotRepository parkingSlotRepository;

    public FirstSlotAvailableStrategy(ParkingLotRepository parkingLotRepository, ParkingSlotRepository parkingSlotRepository){
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }
    @Override
    public ParkingSlot assignSlot(Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGate(gate);
        List<ParkingSlot> allParkingSlots = parkingSlotRepository.getAllParkingSlotsByParkingLot(parkingLot);

        for(ParkingSlot ps: allParkingSlots){
            if(ps.getSlotStatus().equals(ParkingSlotStatus.AVAILABLE) &&
               ps.getSupportedVehicleTypes().contains(vehicleType)){
                return ps;
            }
        }

        return null;
    }
}
