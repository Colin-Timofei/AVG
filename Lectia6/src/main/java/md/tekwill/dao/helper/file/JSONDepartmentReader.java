package md.tekwill.dao.helper.file;

import md.tekwill.domain.Department;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JSONDepartmentReader implements IDTF {

    public static ArrayList<Department> pullDepartments() {

        JSONParser jsonParser = new JSONParser();
        ArrayList<Department> ad = new ArrayList<>();

        try (FileReader reader = new FileReader("departments.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray departmentList = (JSONArray) obj;

            departmentList.forEach(emp -> {
                Department tmp = getDepartmentFromJSONObject((JSONObject) emp);
                ad.add(tmp);
            });

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return ad;
    }

    private static Department getDepartmentFromJSONObject(JSONObject department) {

        JSONObject departmentObject = (JSONObject) department.get("department");

        Department tmp = new Department();
        tmp.setId(((Long) departmentObject.get("id")).intValue());
        tmp.setName((String) departmentObject.get("name"));
        tmp.setCreatedAt(LocalDateTime.parse((String) departmentObject.get("created"), formatter));
        tmp.setLastUpdated(LocalDateTime.parse((String) departmentObject.get("updated"), formatter));

        return tmp;
    }
}
