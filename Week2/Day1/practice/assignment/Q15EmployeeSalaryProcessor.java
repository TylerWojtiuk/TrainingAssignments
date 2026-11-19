package practice.assignment;

public class Q15EmployeeSalaryProcessor {
    static class Employee {
        int id;
        String name;
        Double basicSalary;
        Double bonusPercent;
        Boolean active;

        Employee(int id, String name, String basicSalaryStr, String bonusPercentStr, String activeStr) {
            this.id = id;
            this.name = name;
            this.basicSalary = Double.parseDouble(basicSalaryStr);
            this.bonusPercent = Double.parseDouble(bonusPercentStr);
            this.active = Boolean.parseBoolean(activeStr);
        }

        double getBonus() {
            return basicSalary * (bonusPercent / 100.0);
        }

        double getFinalSalary() {
            return basicSalary + getBonus();
        }
    }

    public static void main(String[] args) {
        try {
            Employee emp = new Employee(101, "Rahul", "60000", "20", "true");

            double bonus = emp.getBonus();
            double finalSalary = emp.getFinalSalary();
            boolean aboveThreshold = finalSalary > 75000.0;
            String upperName = emp.name.toUpperCase();
            String reversedName = new StringBuilder(emp.name).reverse().toString();

            System.out.println("Employee ID: " + emp.id);
            System.out.println("Employee Name: " + upperName);
            System.out.println("Basic Salary: " + emp.basicSalary);
            System.out.println("Bonus: " + bonus);
            System.out.println("Final Salary: " + finalSalary);
            System.out.println("Active: " + emp.active);
            System.out.println("Reversed Name: " + reversedName);
            System.out.println("Salary above 75000: " + (aboveThreshold ? "Yes" : "No"));

            // Reference assignment vs creating a new object
            Employee aliasRef = emp;
            Employee distinctCopy = new Employee(101, "Rahul", "60000", "20", "true");
            System.out.println("Same reference (aliasRef == emp): " + (aliasRef == emp));
            System.out.println("New object reference (distinctCopy == emp): " + (distinctCopy == emp));
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary or bonus input: " + e.getMessage());
        }
    }
}