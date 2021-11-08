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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
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
