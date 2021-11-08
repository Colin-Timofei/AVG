package md.tekwill.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Department department;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    private static int employeeCounter;

    public Employee() {
        this.id = -1;
    }

    public Employee(String firstName, String lastName, Department department) {

        id = employeeCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        createdAt = LocalDateTime.now();
        lastUpdated = createdAt;
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