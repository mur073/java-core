import java.util.HashMap;
import java.util.Map;

public class Factory {
    public static Plane createAirbus() {
        Map<Integer, Plane.Seat> seats = new HashMap<>();
        for (int i = 1; i <= 10; ++i) {
            seats.put(i, new Plane.Seat("First class"));
        }
        for (int i = 11; i <= 28; ++i) {
            seats.put(i, new Plane.Seat("Business class"));
        }
        for (int i = 29; i <= 120; ++i) {
            seats.put(i, new Plane.Seat("Economy"));
        }

        return new Plane("Airbus 31319", 2019, seats);
    }

    public static Plane createBoeing() {
        Map<Integer, Plane.Seat> seats = new HashMap<>();
        for (int i = 1; i <= 12; ++i) {
            seats.put(i, new Plane.Seat("First class"));
        }
        for (int i = 13; i <= 32; ++i) {
            seats.put(i, new Plane.Seat("Business class"));
        }
        for (int i = 32; i <= 128; ++i) {
            seats.put(i, new Plane.Seat("Economy"));
        }

        return new Plane("Boeing 911", 2021, seats);
    }
}
