package src.LLD.airlineManagementSystem;

public class Seat {
    private String id;
    private SeatTypePrice seatType;
    private boolean isBooked = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeatTypePrice getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatTypePrice seatType) {
        this.seatType = seatType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
