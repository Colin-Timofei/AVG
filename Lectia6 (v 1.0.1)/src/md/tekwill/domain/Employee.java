package md.tekwill.domain;

import java.time.LocalDateTime;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Department department;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    private static int employeeCounter;

    public Employee(String firstName, String lastName, Department department) {
        id = employeeCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        createdAt = LocalDateTime.now();
        lastUpdated = createdAt;
    }

    public void setDepartment(Department department) {
        this.department = department;
        lastUpdated = LocalDateTime.now();
    }

    public Department getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        lastUpdated = LocalDateTime.now();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        lastUpdated = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void updateEmployee(Employee employee) {

        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        department.setName(employee.getDepartment().getName());
        lastUpdated = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!getFirstName().equals(employee.getFirstName())) return false;
        if (!getLastName().equals(employee.getLastName())) return false;
        return getDepartment().equals(employee.getDepartment());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getDepartment().hashCode();
        return result;
    }
}
