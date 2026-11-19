package practice.assignment;

public class Q4WrapperConversion {
    public static void main(String[] args) {
        String ageStr = "25";
        String salaryStr = "45000.75";
        String activeStr = "true";

        try {
            Integer age = Integer.valueOf(ageStr);
            Double salary = Double.valueOf(salaryStr);
            Boolean active = Boolean.valueOf(activeStr);

            // Unboxing salary to double for arithmetic, then autoboxing back to Double
            double incrementedSalaryPrimitive = salary * 1.10;
            Double incrementedSalary = Double.valueOf(incrementedSalaryPrimitive);

            System.out.println("Age: " + age + " (" + age.getClass().getSimpleName() + ")");
            System.out.println("Salary: " + salary + " (" + salary.getClass().getSimpleName() + ")");
            System.out.println("Active: " + active + " (" + active.getClass().getSimpleName() + ")");
            System.out.println("Salary after 10% increment: " + incrementedSalary + " (" + incrementedSalary.getClass().getSimpleName() + ")");
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input: " + e.getMessage());
        }
    }
}
