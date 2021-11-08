package md.tekwill.dao.helper.updater;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.time.LocalDateTime;

public class Updater {

    public static void update(Department origin, Department newDepartment) {
        origin.setName(newDepartment.getName());
        origin.setLastUpdated(LocalDateTime.now());
    }

    public static void update(Employee origin, Employee newEmployee) {
        origin.setFirstName(newEmployee.getFirstName());
        origin.setLastName(newEmployee.getLastName());
        origin.setDepartment(newEmployee.getDepartment());
        origin.setLastUpdated(LocalDateTime.now());
    }
}
