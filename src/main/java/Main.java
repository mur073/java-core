import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Plane Booking System *****");

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        planeManager.printPlanes();
                        break;
                    case 2:
                        System.out.print("Enter plane number: ");
                        int planeNum = scanner.nextInt();
                        planeManager.printPlaneDetails(planeNum);
                        break;
                    case 3:
                        System.out.print("Enter plane number: ");
                        int bookPlaneNum = scanner.nextInt();
                        System.out.print("Enter seat number: ");
                        int seatNum = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter passenger name: ");
                        String name = scanner.nextLine();
                        planeManager.bookSeat(bookPlaneNum, seatNum, name);
                        break;
                    case 4:
                        System.out.print("Enter plane number: ");
                        int cancelPlaneNum = scanner.nextInt();
                        System.out.print("Enter seat number: ");
                        int cancelSeatNum = scanner.nextInt();
                        planeManager.cancelSeatBooking(cancelPlaneNum, cancelSeatNum);
                        break;
                    case 5:
                        System.out.print("Enter plane number: ");
                        int detailPlaneNum = scanner.nextInt();
                        System.out.print("Enter seat number: ");
                        int detailSeatNum = scanner.nextInt();
                        planeManager.printBookingDetails(detailPlaneNum, detailSeatNum);
                        break;
                    case 6:
                        System.out.println("Exitting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void printMenu() {
        System.out.println("\n***** MENU *****");
        System.out.println("1. View all planes");
        System.out.println("2. View plane details");
        System.out.println("3. Book a seat");
        System.out.println("4. Cancel booking");
        System.out.println("5. View booking details");
        System.out.println("6. Exit");
    }
}
