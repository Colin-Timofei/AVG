package md.tekwill.dao.impl.array;

import md.tekwill.dao.helper.generator.EmployeeGenerator;
import md.tekwill.dao.helper.updater.Updater;
import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.util.Arrays;
import java.util.Optional;

import static md.tekwill.dao.helper.validator.EmployeeValidator.*;

public class EmployeeDaoImpl implements EmployeeDao {

    private static int arraySize = 0;
    private static Employee[] employees = new Employee[maxEmployees];

    static {
        EmployeeGenerator.generateEmployees(employees);

        for(int i = 0; i < maxEmployees; i++) {
            if(employees[i] != null) {
                arraySize++;
            }
        }
    }

    @Override
    public Employee create(Employee newEmployee) throws Exception {

        if(validateInsert(arraySize, maxEmployees) && validateEmployee(newEmployee)) {
            employees[arraySize++] = newEmployee;
            return read(newEmployee.getId());
        }

        return null;
    }

    @Override
    public Employee read(int employeeId) throws Exception {

        if(validateEmployeeID(employeeId)) {

            Optional<Employee> optional = Arrays.stream(employees)
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
