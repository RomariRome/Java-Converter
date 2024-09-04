package conversions;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Conversions Program\n");
        
        while (true) {
            System.out.print("""
                             1. Fahrenheit to Celsius  2. Celsius to Kelvin
                             3. Feet to Meters         4. Miles to Kilometers
                             5. Time
                             0. Quit Program
                             """);
            
            try {
                int num = input.nextInt();
                if (num == 0) {
                    System.out.println("Exiting the program.");
                    break;
                }
                if (num > 5 || num < 1) {
                    System.out.println("Invalid choice. Please choose again.");
                    continue;
                }
                switch (num) {
                    // 1. Fahrenheit to Celsius
                    case 1 -> {
                        System.out.print("Enter a degree in Fahrenheit.\n");
                        double fahrenheit = input.nextDouble();
                        DecimalFormat df = new DecimalFormat("#.##");
                        
                        // Convert Fahrenheit to Celsius
                        double c = (5.0 / 9) * (fahrenheit - 32);
                        System.out.println(fahrenheit + " F is " + df.format(c) + " C.\n");
                        break;
                    }
                
                    // 2. Celsius to Kelvin
                    case 2 -> {
                        System.out.println("Enter a degree in Celsius.\n");
                        double celsius = input.nextDouble();
                        DecimalFormat df = new DecimalFormat("#.##");
                        
                        // Convert Celsius to Kelvin
                        double k = celsius + 273.15;
                        System.out.println(celsius + " C is " + df.format(k) + " K.\n");
                        break;
                    }
                
                    // 3. Feet to Meters
                    case 3 -> {
                        System.out.println("Enter a distance in Feet.\n");
                        double feet = input.nextDouble();
                        DecimalFormat df = new DecimalFormat("#.####");
                        
                        // Convert Feet to Meters
                        double m = feet / 3.281;
                        double km = m / 1000;
                        System.out.println(feet + " ft is approximately " + df.format(m) + " m or " + df.format(km) + " km.\n");
                        break;
                    }
                
                    // 4. Miles to KM
                    case 4 -> {
                        System.out.println("Enter a distance in Miles.\n");
                        double mile = input.nextDouble();
                        DecimalFormat df = new DecimalFormat("#.##");
                        
                        // Convert Miles to Kilometers
                        double km = mile * 1.60934;
                        System.out.println(mile + " miles is approximately " + df.format(km) + " kilometers.\n");
                        break;
                    }
                
                    // 5. Current Time
                    case 5 -> {
                        CurrentDate date = new CurrentDate();
                        System.out.println("The current date and time is " + date.getFormattedDate() + ".\n");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                input.nextLine(); // Clear the buffer
            }
        }
    }
}

class CurrentDate {
    private final LocalDateTime currentDateTime;
    // Constructor initializes the current date
    CurrentDate() {
        this.currentDateTime = LocalDateTime.now();
    }

    // Returns the formatted current date and time
    String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, Y, hh:mm a");
        return currentDateTime.format(formatter);
    }
}
