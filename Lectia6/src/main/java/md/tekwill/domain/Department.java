package md.tekwill.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class Department {

    private int id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    private static int departmentCounter;

    public Department() {
        this.id = -1;
    }

    public Department(String name) {

        this.id = departmentCounter++;
        this.name = name;
        createdAt = LocalDateTime.now();
        lastUpdated = createdAt;
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
