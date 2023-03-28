package services.strategies.slotAllocationStrategies;

import models.Gate;
import models.ParkingSlot;
import models.enums.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot assignSlot(Gate gate, VehicleType vehicle);
}
