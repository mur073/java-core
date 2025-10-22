import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Plane {
    private final String model;
    private final Integer yearOfManufacture;
    private final Map<Integer, Seat> seats;
    private LocalDateTime departureTime;

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

    public LocalDateTime getDepartureTime() {
        return departureTime;
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

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return String.format(
                "model: '%s', year of manufacture: %d, number of seats: %d, departure time: %s",
                model,
                yearOfManufacture,
                seats.size(),
                departureTime
        );
    }

    public static class Seat {
        private final String seatClass;
        private SeatStatusEnum status;

        public Seat(String seatClass) {
            this.seatClass = seatClass;
            this.status = SeatStatusEnum.AVAILABLE;
        }

        public String getSeatClass() {
            return seatClass;
        }

        public Boolean isPaid() {
            return status.equals(SeatStatusEnum.PAID);
        }

        public Boolean isBooked() {
            return status.equals(SeatStatusEnum.BOOKED);
        }

        public Boolean isAvailable() {
            return status.equals(SeatStatusEnum.AVAILABLE);
        }

        public void book() throws Exception {
            if (isBooked()) {
                throw new Exception("Already booked");
            }
            status = SeatStatusEnum.BOOKED;
        }

        public void pay() throws Exception {
            if (isPaid()) {
                throw new Exception("Already paid");
            }
            if (!isBooked()) {
                throw new Exception("Not available for payment, book first");
            }

            status = SeatStatusEnum.PAID;
        }

        public void cancelBooking() {
            status = SeatStatusEnum.AVAILABLE;
        }

        @Override
        public String toString() {
            return String.format("class: '%s', status: '%s'", seatClass, status.toString());
        }
    }

    public enum SeatStatusEnum {
        AVAILABLE("available"), BOOKED("booked"), PAID("paid");

        final private String text;

        SeatStatusEnum(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
