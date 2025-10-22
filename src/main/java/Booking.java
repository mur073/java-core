import java.time.LocalDateTime;

public class Booking {
    private final String bookedBy;
    private final LocalDateTime bookedAt;
    private static final int BOOKING_DURATION_MINUTES = 24;

    public Booking(String bookedBy) {
        this.bookedBy = bookedBy;
        this.bookedAt = LocalDateTime.now();
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(bookedAt.plusMinutes(BOOKING_DURATION_MINUTES));
    }
}
