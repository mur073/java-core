import java.util.HashMap;
import java.util.Map;

public class Plane {
    private final String model;
    private final Integer yearOfManufacture;
    private final Map<Integer, Seat> seats;

    public Plane(String model, Integer yearOfManufacture, Map<Integer, Seat> seats) {
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public Integer getNumberOfSeats() {
        return seats.size();
    }

    public Map<Integer, Seat> getSeats() {
        return new HashMap<>(seats);
    }

    public Seat getSeatByNumber(int seatNumber) {
        return seats.get(seatNumber);
    }

    public void bookSeat(int seatNumber) throws Exception {
        Seat seat = seats.get(seatNumber);

        if (seat != null) {
            seat.book();
        }
    }

    public void cancelSeatBooking(int seatNumber) {
        Seat seat = seats.get(seatNumber);

        if (seat != null) {
            seat.cancelBooking();
        }
    }

    @Override
    public String toString() {
        return String.format(
                "model: '%s', year of manufacture: %d, number of seats: %d",
                model,
                yearOfManufacture,
                seats.size()
        );
    }

    public static class Seat {
        private final String seatClass;
        private Boolean isBooked;

        public Seat(String seatClass) {
            this.seatClass = seatClass;
            this.isBooked = false;
        }

        public String getSeatClass() {
            return seatClass;
        }

        public Boolean getBooked() {
            return isBooked;
        }

        public void book() throws Exception {
            if (isBooked) {
                throw new Exception("Already booked");
            }
            isBooked = true;
        }

        public void cancelBooking() {
            isBooked = false;
        }

        @Override
        public String toString() {
            return String.format("class: '%s', status: '%s'", seatClass, isBooked ? "booked" : "available");
        }
    }
}
