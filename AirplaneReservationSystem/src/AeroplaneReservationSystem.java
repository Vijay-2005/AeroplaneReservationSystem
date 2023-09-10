

import java.util.Scanner;

public class AeroplaneReservationSystem {

    static boolean[][] seats = new boolean[5][4]; // 5 rows and 4 columns of seats

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to reserve a seat");
            System.out.println("Enter 2 to cancel a reservation");
            System.out.println("Enter 3 to view available seats");
            System.out.println("Enter 4 to exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    viewAvailableSeats();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter row number (1-5): ");
        int row = scanner.nextInt();

        System.out.println("Enter column letter (A-D): ");
        String columnLetter = scanner.next();

        int column = columnLetter.charAt(0) - 'A' + 1;

        if (row < 1 || row > 5 || column < 1 || column > 4) {
            System.out.println("Invalid seat number");
            return;
        }

        if (seats[row - 1][column - 1]) {
            System.out.println("Sorry, seat " + row + "-" + columnLetter + " is already reserved");
        } else {
            seats[row - 1][column - 1] = true;
            System.out.println("Seat " + row + "-" + columnLetter + " reserved successfully");
        }
    }

    static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter row number (1-5): ");
        int row = scanner.nextInt();

        System.out.println("Enter column letter (A-D): ");
        String columnLetter = scanner.next();

        int column = columnLetter.charAt(0) - 'A' + 1;

        if (row < 1 || row > 5 || column < 1 || column > 4) {
            System.out.println("Invalid seat number");
            return;
        }

        if (!seats[row - 1][column - 1]) {
            System.out.println("Sorry, seat " + row + "-" + columnLetter + " is not reserved");
        } else {
            seats[row - 1][column - 1] = false;
            System.out.println("Reservation for seat " + row + "-" + columnLetter + " cancelled successfully");
        }
    }


    static void viewAvailableSeats() {
        System.out.println("All seats: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                char columnLetter = (char) ('A' + j);
                System.out.print((i + 1) + "-" + columnLetter + " ");
            }
            System.out.println();
        }

        System.out.println("Available seats: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (!seats[i][j]) {
                    char columnLetter = (char) ('A' + j);
                    System.out.print((i + 1) + "-" + columnLetter + " ");
                } else {
                    System.out.print("X  ");
                }
            }
            System.out.println();
        }
    }

}