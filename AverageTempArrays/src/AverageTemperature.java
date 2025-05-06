import java.util.Arrays;
import java.util.Scanner;

public class AverageTemperature {
    int[] temps = null;

    // Array constructor

    public AverageTemperature(int size) {
        // Set size of array
        temps = new int[size];

        // Replace default 0 values with MIN_VALUE, so that temperature can be 0 degrees
        for (int i = 0; i < temps.length; i++) {
            temps[i] = Integer.MIN_VALUE;
        }
    }

    // Insert a temperature

    public void insertTemp(int index, int temperature) {
        // Try/catch to catch errors
        try {
            // If index has default value, set the inputted temperature at the chosen index
            if (temps[index] == Integer.MIN_VALUE) {
                temps[index] = temperature;

                System.out.println("Temperature Inserted");
            }
            // Else, the index will already have a temperature
            else {
                System.out.println("This index already has a temperature");
            }
        }
        // Catch error if index is not within the limit of the array
        catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Invalid array index" + error);
        }
    }

    // Calculate average temperature

    public int calculateAverage() {
        // Initialize tempsSum variable
        int tempsSum = 0;

        // Iterate through array to get sum of temperatures
        for (int i = 0; i < temps.length; i++) {
            tempsSum += temps[i];
        }

        // Get average and return
        return tempsSum / temps.length;
    }

    // Get amount of temperatures that are above average temperature

    public String aboveAverage(int averageTemp) {
        // Initialize numTemps
        int numTemps = 0;

        // Iterate through array to find amount of temperatures
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] > averageTemp) {
                numTemps += 1;
            }
        }

        // Print results
        return numTemps + " temperatures exceed the average temperature";
    }

    public static void main(String[] args) {
        // Set scanner for inputs
        Scanner scanner = new Scanner(System.in);

        // Initialize array
        AverageTemperature tempsArray = new AverageTemperature(5);

        // Prompt user to insert temperatures

        // First temperature
        System.out.print("Insert the first temperature: ");
        int temp1 = scanner.nextInt();
        tempsArray.insertTemp(0, temp1);

        // Second temperature
        System.out.print("Insert the second temperature: ");
        int temp2 = scanner.nextInt();
        tempsArray.insertTemp(1, temp2);

        // Third temperature
        System.out.print("Insert the third temperature: ");
        int temp3 = scanner.nextInt();
        tempsArray.insertTemp(2, temp3);

        // Fourth temperature
        System.out.print("Insert fourth temperature: ");
        int temp4 = scanner.nextInt();
        tempsArray.insertTemp(3, temp4);

        // Fifth temperature
        System.out.print("Insert fifth temperature: ");
        int temp5 = scanner.nextInt();
        tempsArray.insertTemp(4, temp5);

        System.out.println();

        // Print temperatures
        System.out.println("Temperatures: " + Arrays.toString(tempsArray.temps));

        // Print average
        int averageTemp = tempsArray.calculateAverage();
        System.out.println("Average Temperature: " + averageTemp);

        // Print amount of temperatures that exceed average
        System.out.println(tempsArray.aboveAverage(averageTemp));
    }
}
