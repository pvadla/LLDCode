package exceptions;

public class NoParkingSlotAvailableException extends Exception {
    public NoParkingSlotAvailableException(String message){
        super(message);
    }
}
