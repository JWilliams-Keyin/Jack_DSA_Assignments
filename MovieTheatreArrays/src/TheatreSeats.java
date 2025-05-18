import java.util.Scanner;

public class TheatreSeats {
    String seats[][] = null;

    // Constructor

    public TheatreSeats() {
        this.seats = new String[3][9];

        // Fill all default values with empty seat symbols (O)
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[0].length; col++) {
                seats[row][col] = "O";
            }
        }
    }

    // Reserve Seats

    public void reserveSeat(int row, int col) {
        try{
            // If seat is empty, reserve it
            if (seats[row][col] == "O") {
                seats[row][col] = "X";
                System.out.println("Seat booked!");
            }
            // Else, it is taken
            else {
                System.out.println("This seat is already taken");
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Invalid seat number");
        }
    }

    // Cancel Seats

    public void cancelSeat(int row, int col) {
        try{
            // If seat is reserved, cancel it
            if (seats[row][col] == "X") {
                seats[row][col] = "O";
                System.out.println("Seat cancelled!");
            }
            // Else, it is open
            else {
                System.out.println("This seat is still open");
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Invalid seat number");
        }
    }

    // Print Seating Diagram

    public String printSeats() {
        // It's messy but it was the only way I could think to label the rows
        System.out.println("  0 1 2 3 4 5 6 7 8");
        System.out.println(
                "0 " + seats[0][0] +
                " " + seats[0][1] +
                " " + seats[0][2] +
                " " + seats[0][3] +
                " " + seats[0][4] +
                " " + seats[0][5] +
                " " + seats[0][6] +
                " " + seats[0][7] +
                " " + seats[0][8]);
        System.out.println(
                "1 " + seats[1][0] +
                " " + seats[1][1] +
                " " + seats[1][2] +
                " " + seats[1][3] +
                " " + seats[1][4] +
                " " + seats[1][5] +
                " " + seats[1][6] +
                " " + seats[1][7] +
                " " + seats[1][8]);
        System.out.println(
                "2 " + seats[2][0] +
                " " + seats[2][1] +
                " " + seats[2][2] +
                " " + seats[2][3] +
                " " + seats[2][4] +
                " " + seats[2][5] +
                " " + seats[2][6] +
                " " + seats[2][7] +
                " " + seats[2][8]);

        // Return a blank line just so the code is passed through
        return " ";
    }

    public static void main(String[] args) {
        // Set scanner for inputs
        Scanner scanner = new Scanner(System.in);

        // Initialize arrays & variables
        TheatreSeats originalSeating = new TheatreSeats();
        TheatreSeats currentSeating = new TheatreSeats();

        boolean runProgram = true;

        // Prompt user to input values

        while (runProgram) {
            System.out.println("Welcome to the Seat Booking Website!");
            System.out.println("Type the number of an option to proceed");
            System.out.println();
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a seat");
            System.out.println("3. See original seating layout");
            System.out.println("4. Exit");

            // Try/catch for error handling

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Current seating layout:");
                System.out.println();
                System.out.println(currentSeating.printSeats());
                System.out.println();

                // Row input
                System.out.print("Input the row of the seat you wish to book: ");
                int bookRow = scanner.nextInt();

                // Column input
                System.out.print("Input the column of the seat you would like to book: ");
                int bookCol = scanner.nextInt();

                // Call function to book seat
                currentSeating.reserveSeat(bookRow, bookCol);
            } else if (choice == 2) {
                System.out.println("Current seating layout:");
                System.out.println();
                System.out.println(currentSeating.printSeats());
                System.out.println();

                // Row input
                System.out.print("Input the row of the seat you wish to cancel: ");
                int cancelRow = scanner.nextInt();

                // Column input
                System.out.print("Input the column of the seat you would like to cancel: ");
                int cancelCol = scanner.nextInt();

                // Call function to cancel seat
                currentSeating.cancelSeat(cancelRow, cancelCol);
            } else if (choice == 3) {
                System.out.println("Original seating layout:");
                System.out.println();
                System.out.println(originalSeating.printSeats());
                System.out.println();
            } else if (choice == 4) {
                System.out.println("Thanks for using our service!");
                runProgram = false;
            }
        }
    }
}
