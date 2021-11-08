package md.tekwill.dao.helper.generator;

import md.tekwill.dao.helper.file.JSONEmployeeReader;
import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeGenerator {

    static ArrayList<Employee> ae = JSONEmployeeReader.pullEmployees();

    public static void generateEmployees(Employee[] employees) {

        System.arraycopy(ae.toArray(new Department[0]), 0, employees, 0, ae.size());
    }

    public static void generateEmployees(ArrayList<Employee> employees) {
        employees.addAll(ae);
    }

    public static void generateEmployees(HashMap<Integer, Employee> employees) {

        employees.putAll(ae.stream().collect(Collectors.toMap(Employee::getId, Function.identity())));
    }
}
