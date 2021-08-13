package md.tekwill.dao.generator;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class Generator {

    private static String[] departmentNames = {"IT", "HR", "Management", "PR", "Marketing", "Customer Service", "Cleaning", "Support", "Security"};
    private static int departmentSize = departmentNames.length;

    private static String[][] employeeNames = {
            {"Ion", "Bunescu", "IT"},
            {"Ana", "Popescu", "PR"},
            {"Rina", "Cristescu", "Management"},
            {"Alexandru", "Stanca", "Marketing"},
            {"Tania", "Stanca", "IT"},
            {"Alina", "Tincu", "Management"},
    };
    private static int employeeSize = employeeNames.length;


    public static void generateDepartments(Department[] departments) {

        for(int i = 0; i < departmentSize; i++) {
            departments[i] = new Department(departmentNames[i]);
        }
    }

    public static void generateDepartments(ArrayList<Department> departments) {

        for(String x : departmentNames) {
            departments.add(new Department(x));
        }
    }

    public static void generateDepartments(HashMap<Integer, Department> departments) {

        for(String x : departmentNames) {
            Department tmp = new Department(x);
            departments.put(tmp.getId(), tmp);
        }
    }

    public static void generateEmployees(Employee[] employees) {

        for(int i = 0; i < employeeSize; i++) {
            employees[i] = new Employee(employeeNames[i][0], employeeNames[i][1], new Department(employeeNames[i][2]));
        }
    }

    public static void generateEmployees(ArrayList<Employee> employees) {

        for(String[] x : employeeNames) {
            employees.add(new Employee(x[0], x[1], new Department(x[2])));
        }
    }

    public static void generateEmployees(HashMap<Integer, Employee> employees) {

        for(String[] x : employeeNames) {
            Employee tmp = new Employee(x[0], x[1], new Department(x[2]));
            employees.put(tmp.getId(), tmp);
        }
    }
}
