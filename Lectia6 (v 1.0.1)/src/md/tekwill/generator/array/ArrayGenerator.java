package md.tekwill.generator.array;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

public class ArrayGenerator {

    public static void generateEmployees(Employee[] employees) {
        String[][] employeeNames = {
                {"Ion", "Bunescu", "IT"},
                {"Ana", "Popescu", "PR"},
                {"Rina", "Cristescu", "Management"},
                {"Alexandru", "Stanca", "Marketing"},
                {"Tania", "Stanca", "IT"},
                {"Alina", "Tincu", "Management"}
        };

        int size = employeeNames.length;

        for(int i = 0; i < size; i++) {
            employees[i] = new Employee(employeeNames[i][0],
                    employeeNames[i][1],
                    new Department(employeeNames[i][2]));
        }
    }

    public static void generateDepartments(Department[] departments) {

        String[] departmentNames = {"IT", "HR", "Management", "PR", "Marketing", "Customer Service", "Cleaning", "Support", "Security"};
        int size = departmentNames.length;

        for(int i = 0; i < size; i++) {
            departments[i] = new Department(departmentNames[i]);
        }
    }
}
