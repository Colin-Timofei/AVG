package md.tekwill.dao.impl.map;

import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;
import md.tekwill.generator.MapGenerator;

import java.util.HashMap;

public class EmployeeDaoMapImpl implements EmployeeDao {

    private final static int maxEmployees = 50;
    private static HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();

    static {
        MapGenerator.generateEmployees(employees);
    }

    @Override
    public Employee create(Employee employee) {

        int position = findFirstEmptyPosition();

        if(position != -1) {
            employees.put(employee.getId(), employee);
            return employee;
        }

        return null;
    }

    @Override
    public Employee read(int employeeId) {

        int position = findPositionById(employeeId);

        if(position != -1) {
            for (Employee x : employees.values()) {
                if (x.getId() == employeeId) {
                    return x;
                }
            }
        }

        return null;
    }

    @Override
    public boolean update(int employeeId, Employee updatedEmployee) {

        int position = findPositionById(employeeId);

        if(position == -1) {
            return false;
        }
        else {
            employees.get(employeeId).setFirstName(updatedEmployee.getFirstName());
            employees.get(employeeId).setLastName(updatedEmployee.getLastName());
            employees.get(employeeId).setDepartment(updatedEmployee.getDepartment());
            return true;
        }
    }

    @Override
    public boolean delete(int employeeId) {

        int position = findPositionById(employeeId);

        if (position == -1) {
            return false;
        } else {
            employees.remove(employeeId);
            return true;
        }
    }


    @Override
    public int findFirstEmptyPosition() {

        return employees.size() < maxEmployees ? employees.size() : -1;
    }

    @Override
    public int findPositionById(int employeeId) {

        for(Employee x : employees.values()) {
            if (x.getId() == employeeId) {
                return -2;
            }
        }

        return -1;
    }

    @Override
    public Employee[] getEmployees() {

        int i = 0;
        Employee[] tmp = new Employee[employees.size()];

        for(Employee x : employees.values()) {
            tmp[i++] = x;
        }

        return tmp;
    }

    @Override
    public int getMaxElements() {

        return maxEmployees;
    }
}
