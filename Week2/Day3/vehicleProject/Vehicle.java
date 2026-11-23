package vehicleProject;

public class Vehicle {
	
	protected String vehicleNumber;
    protected String model;
    protected double ratePerDay;
    protected int days;
	
    public Vehicle(String vehicleNumber, String model, double ratePerDay, int days) {
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.ratePerDay = ratePerDay;
		this.days = days;
	}
    
    public double calculateRent() {
		return ratePerDay * days;
	}
    
    public void displayDetails() {
    	System.out.printf("Vehicle | %-10s | %-6s | Days: %d | Rent: %.1f%n", vehicleNumber, model, days, calculateRent());
    }
    
}
