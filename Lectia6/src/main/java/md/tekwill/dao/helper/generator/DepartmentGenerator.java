package md.tekwill.dao.helper.generator;

import md.tekwill.dao.helper.file.JSONDepartmentReader;
import md.tekwill.domain.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DepartmentGenerator {

    static ArrayList<Department> ad = JSONDepartmentReader.pullDepartments();

    public static void generateDepartments(Department[] departments) {

        System.arraycopy(ad.toArray(new Department[0]), 0, departments, 0, ad.size());
    }

    public static void generateDepartments(ArrayList<Department> departments) {
        departments.addAll(ad);
    }

    public static void generateDepartments(HashMap<Integer, Department> departments) {

        departments.putAll(ad.stream().collect(Collectors.toMap(Department::getId, Function.identity())));
    }
}
