package fileHanding;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int empId;
    private String empName;
    private String department;
    private double salary;

    public Employee(int empId, String empName, String department, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + empId +
               ", Name=" + empName +
               ", Department=" + department +
               ", Salary=" + salary + "]";
    }
}
