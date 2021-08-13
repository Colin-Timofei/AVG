package md.tekwill.dao.impl.array;

import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.util.Arrays;

import static md.tekwill.dao.validator.Validator.*;
import static md.tekwill.dao.generator.Generator.*;

public class EmployeeDaoImpl implements EmployeeDao {

    private static int arraySize = 0;
    private static Employee[] employees = new Employee[maxEmployees];

    static {
        generateEmployees(employees);

        for(int i = 0; i < maxEmployees; i++) {
            if(employees[i] != null) {
                arraySize++;
            }
        }
    }

    @Override
    public Employee create(Employee newEmployee) throws Exception {

        if(checkInsert(arraySize, maxEmployees) && validateEmployee(newEmployee)) {
            for(Employee x : employees) {
                if(x == null) {
                    x = newEmployee;
                    arraySize++;
                    return read(newEmployee.getId());
                }
            }
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
            read(employeeId).updateEmployee(updatedEmployee);
            return read(employeeId);
        }

        return null;
    }

    @Override
    public boolean delete(int employeeId) throws Exception {

        if (validateEmployeeID(employeeId)) {
            for (int i = 0; i < maxEmployees; i++) {
                if(employees[i] != null && employees[i].getId() == employeeId) {
                    moveToRightFromPosition(i);
                    arraySize--;
                    return true;
                }
            }
        }
        return false;
    }

    private void moveToRightFromPosition(int position) {

        for(int i = position; i < maxEmployees-1; i++)  {
            employees[i] = employees[i+1];
        }

        employees[maxEmployees-1] = null;
    }

    public Employee[] getEmployees() {
        return Arrays.copyOfRange(employees, 0, arraySize-1);
    }
}
