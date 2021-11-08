package md.tekwill.dao.helper.validator;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;
import md.tekwill.dao.helper.validator.DepartmentValidator;

import java.util.ArrayList;

import static md.tekwill.dao.helper.validator.DepartmentValidator.*;

public class EmployeeValidator extends Validator {

    public static boolean validateEmployeeID(int ID) throws Exception {

        return validateID(ID, "Not a valid Employee ID !");
    }

    public static boolean validateEmployee(Employee employee) throws Exception {
        return checkNull(employee, "Employee cannot be null !")
                && validateEmployeeID(employee.getId())
                && validateString(employee.getFirstName(), "Employee")
                && validateString(employee.getLastName(), "Employee")
                && validateDepartment(employee.getDepartment());
    }
}
