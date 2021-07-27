package md.tekwill.generator;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.util.ArrayList;

public class ArrayListGenerator {

    public static void generateEmployees(ArrayList<Employee> employees) {

        String[][] employeeNames = {
                {"Ala", "Potap", "HQ"},
                {"Ion", "Bunescu", "IT"},
                {"Ana", "Popescu", "PR"},
                {"Rina", "Cristescu", "Management"},
                {"Alexandru", "Stanca", "Marketing"},
                {"Tania", "Stanca", "IT"},
                {"Alina", "Tincu", "Management"}
        };

        for(String[] employee : employeeNames) {
            employees.add(new Employee(employee[0], employee[1], new Department(employee[2])));
        }
    }

    public static void generateDepartments(ArrayList<Department> departments) {

        String[] departmentNames = {"IT", "HR", "Management", "HQ", "PR", "Marketing", "Security"};

        for(String department : departmentNames) {
            departments.add(new Department(department));
        }
    }
}
