package md.tekwill.dao.helper.file;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JSONEmployeeReader implements IDTF {

    public static ArrayList<Employee> pullEmployees() {

        JSONParser jsonParser = new JSONParser();
        ArrayList<Employee> ae = new ArrayList<>();

        try (FileReader reader = new FileReader("employees.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;

            employeeList.forEach(emp -> {
                Employee tmp = getEmployeeFromJSONObject((JSONObject) emp);
                ae.add(tmp);
            });

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return ae;
    }

    private static Employee getEmployeeFromJSONObject(JSONObject employee) {

        JSONObject employeeObject = (JSONObject) employee.get("employee");

        Employee tmp = new Employee();
        tmp.setId(((Long) employeeObject.get("id")).intValue());
        tmp.setFirstName((String) employeeObject.get("firstname"));
        tmp.setLastName((String) employeeObject.get("lastname"));
        tmp.setDepartment(new Department((String) employeeObject.get("department")));
        tmp.setCreatedAt(LocalDateTime.parse((String) employeeObject.get("created"), formatter));
        tmp.setLastUpdated(LocalDateTime.parse((String) employeeObject.get("updated"), formatter));

        return tmp;
    }
}
