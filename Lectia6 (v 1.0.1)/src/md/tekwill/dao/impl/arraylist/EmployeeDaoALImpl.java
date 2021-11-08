package md.tekwill.dao.impl.arraylist;

import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Employee;

import static md.tekwill.dao.helper.validator.Validator.*;
import static md.tekwill.dao.helper.generator.Generator.*;

import java.util.ArrayList;

public class EmployeeDaoALImpl implements EmployeeDao {

    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    static {
        generateEmployees(employees);
    }

    @Override
    public Employee create(Employee newEmployee) throws Exception {

        if(checkInsert(employees.size(), maxEmployees) && validateEmployee(newEmployee)) {
            employees.add(newEmployee);
            return read(newEmployee.getId());
        }

        return null;
    }

    @Override
    public Employee read(int employeeId) throws Exception {

        if(validateEmployeeID(employeeId)) {
            for (Employee x : employees) {
                if(x.getId() == employeeId) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public Employee update(int employeeId, Employee updatedEmployee) throws Exception {

        if(validateEmployeeID(employeeId) && validateEmployee(updatedEmployee)) {
//            read(employeeId).updateEmployee(updatedEmployee);
            return read(employeeId);
        }

        return null;
    }

    @Override
    public boolean delete(int employeeId) throws Exception {

        if (validateEmployeeID(employeeId)) {
            if(read(employeeId) != null) {
                employees.remove(read(employeeId));
                return true;
            }
        }
        return false;
    }

    public Employee[] getEmployees() {

        return employees.toArray(new Employee[0]);
    }
}
