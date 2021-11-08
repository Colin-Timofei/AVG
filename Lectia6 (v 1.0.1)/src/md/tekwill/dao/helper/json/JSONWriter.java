package md.tekwill.dao.helper.json;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriter
{

    public static void departmentToJSON() {

        ArrayList<Department> ad = new ArrayList<>();

        ad.add(new Department("Linda"));
        ad.add(new Department("Sonya"));
        ad.add(new Department("Bechku"));

        JSONArray departmentList = new JSONArray();

        for(Department x : ad) {
            JSONObject tmp = new JSONObject();
            tmp.put("id", x.getId());
            tmp.put("name", x.getName());
            departmentList.add(tmp);
        }

        try (FileWriter file = new FileWriter("departments.json")) {
            file.write(departmentList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void employeeToJSON() {

        ArrayList<Employee> ad = new ArrayList<>();

        ad.add(new Employee("Ion", "Stanescu", new Department("IT")));
        ad.add(new Employee("Irina", "Stanescu", new Department("IT")));
        ad.add(new Employee("Tania", "Bulca", new Department("IT")));

        JSONArray departmentList = new JSONArray();

        for(Employee x : ad) {
            JSONObject tmp = new JSONObject();
            departmentList.add(tmp);
        }

        try (FileWriter file = new FileWriter("departments.json")) {
            file.write(departmentList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        departmentToJSON();
    }
}
