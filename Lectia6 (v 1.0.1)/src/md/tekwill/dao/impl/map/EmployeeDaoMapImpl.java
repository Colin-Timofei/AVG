package md.tekwill.dao.impl.map;

import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Employee;

import static md.tekwill.dao.validator.Validator.*;
import static md.tekwill.dao.generator.Generator.*;

import java.util.HashMap;

public class EmployeeDaoMapImpl implements EmployeeDao {

    private static HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();

    static {
        generateEmployees(employees);
    }

    @Override
    public Employee create(Employee newEmployee) throws Exception {

        if(checkInsert(employees.size(), maxEmployees) && validateEmployee(newEmployee)) {
            employees.put(newEmployee.getId(), newEmployee);
            return read(newEmployee.getId());
        }

        return null;
    }

    @Override
    public Employee read(int employeeId) throws Exception {

        if(validateEmployeeID(employeeId)) {
            return employees.get(employeeId);
        }
        return null;
    }

    @Override
    public Employee update(int employeeId, Employee updatedEmployee) throws Exception {

        if(validateEmployeeID(employeeId) && validateEmployee(updatedEmployee)) {
            read(employeeId).updateEmployee(updatedEmployee);
            return read(employeeId);
        }

        return null;
    }

    @Override
    public boolean delete(int employeeId) throws Exception {

        if (validateEmployeeID(employeeId)) {
            if(read(employeeId) != null) {
                employees.remove(employeeId);
                return true;
            }
        }
        return false;
    }

    public Employee[] getEmployees() {

        return employees.values().toArray(new Employee[0]);
    }
}
