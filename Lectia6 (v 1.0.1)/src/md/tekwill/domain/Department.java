package md.tekwill.domain;

public class Department {
    private int id;
    private String name;

    private static int departmentCounter;

    public Department(String name) {
        this.id = departmentCounter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
