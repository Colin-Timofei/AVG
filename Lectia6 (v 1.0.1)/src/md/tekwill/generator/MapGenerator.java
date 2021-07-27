package md.tekwill.generator;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.util.HashMap;

public class MapGenerator {

    public static void generateEmployees(HashMap<Integer, Employee> employees) {

        String[][] employeeNames = {
                {"Krina", "Bobu", "DDT"},
                {"Ion", "Bunescu", "IT"},
                {"Ana", "Popescu", "PR"},
                {"Rina", "Cristescu", "Management"},
                {"Alexandru", "Stanca", "Marketing"},
                {"Tania", "Stanca", "IT"},
                {"Alina", "Tincu", "Management"}
        };

        for(String[] employee : employeeNames) {
            Employee tmp = new Employee(employee[0], employee[1], new Department(employee[2]));
            employees.put(tmp.getId(), tmp);
        }
    }

    public static void generateDepartments(HashMap<Integer, Department> departments) {

        String[] departmentNames = {"DDT", "IT", "HR", "Management", "HQ", "PR", "Marketing", "Security"};

        for(String department : departmentNames) {
            Department tmp = new Department(department);
            departments.put(tmp.getId(), tmp);
        }
    }
}
