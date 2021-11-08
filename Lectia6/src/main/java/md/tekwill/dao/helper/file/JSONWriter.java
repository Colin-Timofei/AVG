package md.tekwill.dao.helper.file;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.ArrayList;

public class JSONWriter implements IDTF {

    public static void pushDepartments(ArrayList<Department> ad) {

        JSONArray departmentList = new JSONArray();

        for(Department tmp : ad) {

            JSONObject currentDepartment = new JSONObject();
            currentDepartment.put("id", tmp.getId());
            currentDepartment.put("name", tmp.getName());
            currentDepartment.put("created", tmp.getCreatedAt().format(formatter));
            currentDepartment.put("updated", tmp.getLastUpdated().format(formatter));

            JSONObject departmentObject = new JSONObject();
            departmentObject.put("department", currentDepartment);

            departmentList.add(departmentObject);
        }

        try (FileWriter file = new FileWriter("departments.json")) {
            file.write(departmentList.toJSONString());
            file.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pushEmployees(ArrayList<Employee> ae) {

        JSONArray employeeList = new JSONArray();

        for(Employee tmp : ae) {

            JSONObject currentEmployee = new JSONObject();
            currentEmployee.put("id", tmp.getId());
            currentEmployee.put("firstname", tmp.getFirstName());
            currentEmployee.put("lastname", tmp.getLastName());
            currentEmployee.put("department", tmp.getDepartment().getName());
            currentEmployee.put("created", tmp.getCreatedAt().format(formatter));
            currentEmployee.put("updated", tmp.getLastUpdated().format(formatter));

            JSONObject employeeObject = new JSONObject();
            employeeObject.put("employee", currentEmployee);

            employeeList.add(employeeObject);
        }

        try (FileWriter file = new FileWriter("employees.json")) {
            file.write(employeeList.toJSONString());
            file.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
