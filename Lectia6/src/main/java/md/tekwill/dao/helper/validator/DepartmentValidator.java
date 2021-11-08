package md.tekwill.dao.helper.validator;

import md.tekwill.dao.helper.generator.EmployeeGenerator;
import md.tekwill.domain.Department;

import java.util.ArrayList;

public class DepartmentValidator extends Validator {

    public static boolean validateDepartmentID(int ID) throws Exception {

        return validateID(ID, "Not a valid Department ID !");
    }

    public static boolean validateDepartmentName(String string) throws Exception{

        return validateString(string, "Department");
    }

    public static boolean validateDepartment(Department department) throws Exception {

        return checkNull(department, "Department cannot be null !")
                && validateDepartmentID(department.getId())
                && validateDepartmentName(department.getName());
    }
}
