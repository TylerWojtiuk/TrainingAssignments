package com.smartstore.billing;

import java.util.Scanner;
import java.util.Locale;

/**
 * Console application that calculates employee salary details.
 */
public class SalaryCalculator {

    /**
     * Calculates the gross salary.
     */
    public static double calculateGross(double basic, double hra, double da) {
        return basic + hra + da;
    }

    /**
     * Calculates professional tax.
     * Tax is Rs. 200 only when gross salary is strictly above Rs. 20,000.
     */
    public static double calculateProfessionalTax(double gross) {
        if (gross > 20000) {
            return 200.0;
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        // Allowances are percentages of the basic salary
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;

        double grossSalary = calculateGross(basicSalary, hra, da);
        double professionalTax = calculateProfessionalTax(grossSalary);
        double netSalary = grossSalary - professionalTax;

        // Display employee salary details
        System.out.println("\nEmployee Salary Details");
        System.out.println("-----------------------");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.printf(Locale.US, "Basic Salary: Rs. %.2f%n", basicSalary);
        System.out.printf(Locale.US, "HRA (20%%): Rs. %.2f%n", hra);
        System.out.printf(Locale.US, "DA (10%%): Rs. %.2f%n", da);
        System.out.printf(Locale.US, "Gross Salary: Rs. %.2f%n", grossSalary);
        System.out.printf(Locale.US, "Professional Tax: Rs. %.2f%n", professionalTax);
        System.out.printf(Locale.US, "Net Salary: Rs. %.2f%n", netSalary);

        scanner.close();
    }
}
