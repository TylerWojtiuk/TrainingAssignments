package fileHanding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerializationDemo {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        // Create and initialize an array of 5 Employee objects
        Employee[] employees = {
            new Employee(101, "Alice Johnson", "Engineering", 85000.00),
            new Employee(102, "Bob Smith", "Marketing", 64000.00),
            new Employee(103, "Carol Davis", "Finance", 72000.00),
            new Employee(104, "David Wilson", "HR", 59000.00),
            new Employee(105, "Eva Martinez", "Operations", 68500.00)
        };

        // Write the complete Employee array to employees.dat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Successfully wrote 5 employees to " + FILE_NAME + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }

        // Read the Employee array back from employees.dat and display details
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Employee[] retrievedEmployees = (Employee[]) ois.readObject();
            System.out.println("Retrieved Employee Details:");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}