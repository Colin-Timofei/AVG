package md.tekwill.dao.impl.arraylist;

import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Employee;
import md.tekwill.generator.ArrayListGenerator;

import java.util.ArrayList;

public class EmployeeDaoALImpl implements EmployeeDao {

    private final static int maxEmployees = 50;
    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    static {
        ArrayListGenerator.generateEmployees(employees);
    }

    @Override
    public Employee create(Employee employee) {

        int position = findFirstEmptyPosition();

        if(position == -1) {
            return null;
        }
        else {
            employees.add(employee);
            return employees.get(position);
        }
    }

    @Override
    public Employee read(int employeeId) {

        int position = findPositionById(employeeId);

        if(position == -1) {
            return null;
        }
        else {
            return employees.get(position);
        }
    }

    @Override
    public boolean update(int employeeId, Employee updatedEmployee) {

        int position = findPositionById(employeeId);

        if(position == -1) {
            return false;
        }
        else {
            employees.get(position).setFirstName(updatedEmployee.getFirstName());
            employees.get(position).setLastName(updatedEmployee.getLastName());
            employees.get(position).setDepartment(updatedEmployee.getDepartment());
            return true;
        }
    }

    @Override
    public boolean delete(int employeeId) {

        int position = findPositionById(employeeId);

        if (position == -1) {
            return false;
        } else {
            employees.remove(position);
            return true;
        }
    }


    @Override
    public int findFirstEmptyPosition() {

        return employees.size() < maxEmployees ? employees.size() : -1;
    }

    @Override
    public int findPositionById(int employeeId) {

        for(Employee x : employees) {
            if (x.getId() == employeeId) {
                return employees.indexOf(x);
            }
        }

        return -1;
    }

    @Override
    public Employee[] getEmployees() {

        int size = employees.size();
        Employee[] tmp = new Employee[size];

        for(int i = 0; i < size; i++) {
            tmp[i] = employees.get(i);
        }

        return tmp;
    }

    @Override
    public int getMaxElements() {

        return maxEmployees;
    }
}
