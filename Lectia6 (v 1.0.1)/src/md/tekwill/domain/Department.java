package md.tekwill.domain;

import java.time.LocalDateTime;

public class Department {
    private int id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    private static int departmentCounter;

    public Department(String name) {
        this.id = departmentCounter++;
        this.name = name;
        createdAt = LocalDateTime.now();
        lastUpdated = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        lastUpdated = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void updateDepartment(Department department) {
        name = department.getName();
        lastUpdated = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
