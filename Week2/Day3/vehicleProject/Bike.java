package vehicleProject;

public class Bike extends Vehicle{
	
	private static final double DISCOUNT_RATE = 0.10;

    public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
        super(vehicleNumber, model, ratePerDay, days); // Inheritance: Calls parent constructor
    }

    // Polymorphism: Overrides Vehicle.calculateRent() with a 10% discount
    @Override
    public double calculateRent() {
        return (ratePerDay * days) * (1.0 - DISCOUNT_RATE);
    }

    // Polymorphism: Overrides Vehicle.displayDetails()
    @Override
    public void displayDetails() {
        System.out.printf("Bike | %-10s | %-6s | Days: %d | Rent: %.1f%n",
                vehicleNumber, model, days, calculateRent());
    }

}
