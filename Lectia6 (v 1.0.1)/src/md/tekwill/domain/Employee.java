package md.tekwill.domain;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Department department;

    private static int employeeCounter;

    public Employee(String firstName, String lastName, Department department) {
        id = employeeCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
