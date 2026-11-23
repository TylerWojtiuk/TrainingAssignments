package vehicleProject;

import java.util.Scanner;

public class RentalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Polymorphism: Parent-type array storing Car and Bike instances
        Vehicle[] vehicles = new Vehicle[count];

        for (int i = 0; i < count; i++) {
            int type = 0;
            while (true) {
                System.out.print("Enter type (1-Car, 2-Bike): ");
                if (scanner.hasNextInt()) {
                    type = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (type == 1 || type == 2) {
                        break;
                    }
                } else {
                    scanner.nextLine(); // Discard invalid token
                }
                System.out.println("Invalid vehicle type. Please enter 1 for Car or 2 for Bike.");
            }

            System.out.print("Enter Vehicle Number: ");
            String vehicleNumber = scanner.nextLine();

            System.out.print("Enter Model: ");
            String model = scanner.nextLine();

            System.out.print("Enter Rate per Day: ");
            double ratePerDay = scanner.nextDouble();

            System.out.print("Enter Days: ");
            int days = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Polymorphism: Assigned to Vehicle reference
            Vehicle v;
            if (type == 1) {
                System.out.print("Enter Insurance per Day: ");
                double insurancePerDay = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                v = new Car(vehicleNumber, model, ratePerDay, days, insurancePerDay);
            } else {
                v = new Bike(vehicleNumber, model, ratePerDay, days);
            }

            vehicles[i] = v;
        }

        System.out.println("--- Rental Details ---");
        double totalRent = 0.0;

        // Runtime Polymorphism: Dynamic dispatch invokes Car or Bike methods at runtime
        for (Vehicle v : vehicles) {
            v.displayDetails();
            totalRent += v.calculateRent();
        }

        System.out.printf("Total Rent Collected: %.1f%n", totalRent);

        scanner.close();
    }
}