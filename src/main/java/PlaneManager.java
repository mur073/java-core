import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class PlaneManager {
    final private HashMap<Integer, Plane> planes;
    final private HashMap<String, Booking> bookings;

    public PlaneManager() {
        planes = loadPlanes();
        bookings = loadBookings();

        onShutdown();
    }

    public HashMap<Integer, Plane> getPlanes() {
        return new HashMap<>(planes);
    }

    public void bookSeat(int planeNumber, int seatNumber, String fullName) {
        try {
            String bookingId = getBookingId(planeNumber, seatNumber);

            Plane plane = planes.get(planeNumber);
            if (plane == null) {
                System.out.println("Plane " + planeNumber + " " + "not found");
                return;
            }

            Plane.Seat seat = plane.getSeatByNumber(seatNumber);
            if (seat == null) {
                System.out.println("Seat " + seatNumber + " not found in plane " + planeNumber);
                return;
            }

            seat.book();
            bookings.put(bookingId, new Booking(fullName));

            System.out.println("Seat " + seatNumber + " in plane " + planeNumber + " booked successfully");
        } catch (Exception e) {
            System.out.println("Couldn't book a seat: " + e.getMessage());
        }
    }

    public void payForSeat(int planeNumber, int seatNumber) {
        try {
            String bookingId = getBookingId(planeNumber, seatNumber);
            Booking booking = bookings.get(bookingId);

            if (booking == null) {
                System.out.println("Booking not found");
            }

            Plane plane = planes.get(planeNumber);
            Plane.Seat seat = plane.getSeatByNumber(seatNumber);
            seat.pay();

            System.out.println("Booking " + seatNumber + " in plane " + planeNumber + " is paid successfully");
        } catch (Exception e) {
            System.out.println("Couldn't book a seat: " + e.getMessage());
        }
    }

    private String getBookingId(int planeNumber, int seatNumber) {
        return planeNumber + "_" + seatNumber;
    }

    public void cancelSeatBooking(int planeNumber, int seatNumber) {
        String bookingId = getBookingId(planeNumber, seatNumber);
        Booking booking = bookings.get(bookingId);

        if (booking == null) {
            System.out.println("Booking not found");
            return;
        }

        planes.get(planeNumber).cancelSeatBooking(seatNumber);
        System.out.println("Booking cancelled for " + booking.getBookedBy());
    }

    public void printPlanes() {
        planes.forEach((planeNumber, plane) -> {
            System.out.println("Plane " + planeNumber);
            System.out.println(plane);
            System.out.println();
        });
    }

    public void printPlaneDetails(int planeNumber) {
        Plane plane = planes.get(planeNumber);

        if (plane == null) {
            System.out.println("Plane not found");
            return;
        }

        System.out.println("Plane " + planeNumber + " details");
        System.out.println(plane);
        System.out.printf("Seats (%d total):\n", plane.getNumberOfSeats());

        LocalDateTime now = LocalDateTime.now();
        plane.getSeats().forEach((seatNumber, seat) -> {
            Booking booking = bookings.get(getBookingId(planeNumber, seatNumber));

            boolean isBookedAndUnpaidExpired = seat.isBooked() && !seat.isPaid() && booking.isExpired();
            if (isBookedAndUnpaidExpired) {
                cancelSeatBooking(planeNumber, seatNumber);
            }

            System.out.println(seatNumber + ". " + seat);
        });
        System.out.println();
    }

    public void printBookingDetails(int planeNumber, int seatNumber) {
        String bookingId = planeNumber + "_" + seatNumber;
        Booking booking = bookings.get(bookingId);
        Plane plane = planes.get(planeNumber);
        Plane.Seat seat = plane.getSeatByNumber(seatNumber);

        System.out.printf("Plane %d, seat %d:\n", planeNumber, seatNumber);

        if (booking == null) {
            System.out.println("Booking not found");
            return;
        }

        boolean isBookedAndUnpaidExpired = seat.isBooked() && !seat.isPaid() && booking.isExpired();
        if (isBookedAndUnpaidExpired) {
            cancelSeatBooking(planeNumber, seatNumber);
        }

        System.out.printf("Booked by %s at %s\n", booking.getBookedBy(), booking.getBookedAt());
        System.out.println(seat);
    }

    private HashMap<Integer, Plane> loadPlanes() {
        HashMap<Integer, Plane> loadedPlanes = new HashMap<>();

        try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/planes.txt"))) {
            int planeNumber = 1;

            while (scanner.hasNextLine()) {
                String model = scanner.nextLine().trim();

                if (!model.isEmpty()) {
                    Plane plane;
                    switch (model.toLowerCase()) {
                        case "airbus":
                            plane = Factory.createAirbus();
                            break;
                        case "boeing":
                            plane = Factory.createBoeing();
                            break;
                        default:
                            System.out.println("Unknown plane model: " + model);
                            continue;
                    }

                    loadedPlanes.put(planeNumber++, plane);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading planes: " + e.getMessage());
        }

        return loadedPlanes;
    }

    private HashMap<String, Booking> loadBookings() {
        HashMap<String, Booking> loadedBookings = new HashMap<>();

        try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/bookings.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (!line.isEmpty()) {
                    String[] parts = line.split(",");

                    if (parts.length == 3) {
                        int planeNumber = Integer.parseInt(parts[0].trim());
                        int seatNumber = Integer.parseInt(parts[1].trim());
                        String fullName = parts[2].trim();

                        String bookingId = getBookingId(planeNumber, seatNumber);
                        loadedBookings.put(bookingId, new Booking(fullName));

                        Plane plane = planes.get(planeNumber);
                        if (plane != null) {
                            Plane.Seat seat = plane.getSeatByNumber(seatNumber);
                            if (seat != null) {
                                seat.book();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading bookings: " + e.getMessage());
        }

        return loadedBookings;
    }

    private void savePlanes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/planes.txt"))) {
            planes.forEach((planeNumber, plane) -> {
                String model = plane.getModel().toLowerCase().contains("airbus") ? "airbus" : "boeing";
                writer.println(model);
            });
        } catch (IOException e) {
            System.out.println("Error saving planes: " + e.getMessage());
        }
    }

    private void saveBookings() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/bookings.txt"))) {
            bookings.forEach((bookingId, booking) -> {
                String[] parts = bookingId.split("_");
                int planeNumber = Integer.parseInt(parts[0]);
                int seatNumber = Integer.parseInt(parts[1]);
                writer.println(planeNumber + "," + seatNumber + "," + booking.getBookedBy());
            });
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }

    public void onShutdown() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            savePlanes();
            saveBookings();
            System.out.println("Booking info saved successfully in resources folder");
        }));
    }
}
