package models;

import models.enums.ParkingSlotStatus;
import models.enums.VehicleType;

import java.util.List;

public class ParkingSlot extends BaseModel  {
    private String slotNumber;
    private ParkingSlotStatus slotStatus;
    private List<VehicleType> supportedVehicleTypes;

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(ParkingSlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }
}
