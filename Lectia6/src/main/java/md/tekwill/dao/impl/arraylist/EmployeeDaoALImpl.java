package md.tekwill.dao.impl.arraylist;

import md.tekwill.dao.helper.generator.DepartmentGenerator;
import md.tekwill.dao.helper.generator.EmployeeGenerator;
import md.tekwill.dao.helper.updater.Updater;
import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static md.tekwill.dao.helper.validator.EmployeeValidator.*;
import static md.tekwill.dao.helper.validator.Validator.*;


public class EmployeeDaoALImpl implements EmployeeDao {

    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    static {
        EmployeeGenerator.generateEmployees(employees);
    }

    @Override
    public Employee create(Employee newEmployee) throws Exception {

        if(validateInsert(employees.size(), maxEmployees) && validateEmployee(newEmployee)) {
            employees.add(newEmployee);
            return read(newEmployee.getId());
        }

        return null;
    }

    @Override
    public Employee read(int employeeId) throws Exception {

        if(validateEmployeeID(employeeId)) {

            Optional<Employee> optional = employees.stream()
                    .filter(x -> x.getId() == employeeId)
                    .findFirst();

            if(optional.isPresent()) {
                return optional.get();
            }
        }

        return null;
    }

    @Override
    public Employee update(int employeeId, Employee updatedEmployee) throws Exception {

        if (validateEmployeeID(employeeId) && validateEmployee(updatedEmployee)) {
            if (read(employeeId) != null) {
                Updater.update(read(employeeId), updatedEmployee);
                return read(employeeId);
            }
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