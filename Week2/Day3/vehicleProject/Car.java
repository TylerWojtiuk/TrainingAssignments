package vehicleProject;

public class Car extends Vehicle {
	
	private double insurancePerDay;

    public Car(String vehicleNumber, String model, double ratePerDay, int days, double insurancePerDay) {
        super(vehicleNumber, model, ratePerDay, days); // Inheritance: Calls parent constructor
        this.insurancePerDay = insurancePerDay;
    }

    // Polymorphism: Overrides Vehicle.calculateRent()
    @Override
    public double calculateRent() {
        return (ratePerDay + insurancePerDay) * days;
    }

    // Polymorphism: Overrides Vehicle.displayDetails()
    @Override
    public void displayDetails() {
        System.out.printf("Car  | %-10s | %-6s | Days: %d | Rent: %.1f%n",
                vehicleNumber, model, days, calculateRent());
    }
	
}
