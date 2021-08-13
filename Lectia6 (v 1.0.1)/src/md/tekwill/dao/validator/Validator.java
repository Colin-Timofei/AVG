package md.tekwill.dao.validator;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

public class Validator {

    public static boolean checkInsert(int usedSpace, int maxSpace) throws Exception {

        if(usedSpace < maxSpace) {
            return true;
        } else {
            throw new Exception("No free space to add new record !");
        }
    }

    public static boolean validateID(int ID, String message) throws Exception {

        if(ID >= 0) {
            return true;
        } else {
            throw new Exception(message);
        }
    }

    public static boolean validateDepartmentID(int ID) throws Exception {

        return validateID(ID, "Not a valid Department ID !");
    }

    public static boolean validateEmployeeID(int ID) throws Exception {

        return validateID(ID, "Not a valid Employee ID !");
    }

    private static boolean checkNull(Object object, String message) throws Exception {

        if(object == null) {
            throw new Exception(message);
        }

        return true;
    }

    private static boolean checkNull(String string, String message) throws Exception {

        if(string == null) {
            throw new Exception(message);
        }

        return true;
    }

    private static boolean checkEmpty(String string, String message) throws Exception {

        if(string.trim().isEmpty()) {
            throw new Exception(message);
        }

        return true;
    }

    private static boolean checkSize(String string, String message) throws Exception {

        if(string.length() < 2 || string.length() > 20) {
            throw new Exception(message);
        }

        return true;
    }

    private static boolean checkName(String string, String message) throws Exception {

        if(!string.chars().allMatch(c -> Character.isLetterOrDigit(c) || Character.isWhitespace(c))) {
            throw new Exception(message);
        }

        return true;
    }

    private static boolean validateString(String string, String errorHead) throws Exception {

        return checkNull(string, errorHead + " name cannot be null !")
                && checkEmpty(string, errorHead + " name cannot be blank !")
                && checkSize(string, errorHead + " name must be at least 2 letters long and cannot exceed 20 characters !")
                && checkName(string, errorHead + " must contain only letters, digits or space !");
    }

    public static boolean validateDepartmentName(String string) throws Exception{

        return validateString(string, "Department");
    }

    public static boolean validateDepartment(Department department) throws Exception {

        return checkNull(department, "Department cannot be null !")
                && validateDepartmentID(department.getId())
                && validateDepartmentName(department.getName());
    }

    public static boolean validateEmployee(Employee employee) throws Exception {
        return checkNull(employee, "Employee cannot be null !")
                && validateEmployeeID(employee.getId())
                && validateString(employee.getFirstName(), "Employee")
                && validateString(employee.getLastName(), "Employee")
                && validateDepartment(employee.getDepartment());
    }
}