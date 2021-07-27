package md.tekwill.dao.impl.array;


import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.domain.Employee;
import md.tekwill.generator.ArrayGenerator;

public class EmployeeDaoImpl implements EmployeeDao {

    private final static int maxEmployees = 50;
    private static Employee[] employees = new Employee[maxEmployees];

    static {
        ArrayGenerator.generateEmployees(employees);
    }

    @Override
    public Employee create(Employee newEmployee) {

        int position = findFirstEmptyPosition();

        if(position == -1) {
            return null;
        }
        else {
            employees[position] = newEmployee;
            return employees[position];
        }
    }

    @Override
    public Employee read(int employeeId) {

        int position = findPositionById(employeeId);

        if(position == -1) {
            return null;
        }
        else {
            return employees[position];
        }
    }

    @Override
    public boolean update(int employeeId, Employee updatedEmployee) {

        int position = findPositionById(employeeId);

        if(position == -1) {
            return false;
        }
        else {
            employees[position].setFirstName(updatedEmployee.getFirstName());
            employees[position].setLastName(updatedEmployee.getLastName());
            employees[position].setDepartment(updatedEmployee.getDepartment());
            return true;
        }
    }

    @Override
    public boolean delete(int employeeId) {

        int position = findPositionById(employeeId);

        if(position == -1) {
            return false;
        }
        else {
            moveToRightFromPosition(position);
            return true;
        }
    }

    public int findFirstEmptyPosition() {

        for(int i = 0; i < maxEmployees; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int findPositionById(int employeeId) {

        for(int i = 0; i < maxEmployees; i++) {
            if(employees[i] != null && employees[i].getId() == employeeId) {
                return i;
            }
        }
        return -1;
    }

    private void moveToRightFromPosition(int position) {

        for(int i = position; i < maxEmployees-1; i++)  {
            employees[i] = employees[i+1];
        }

        employees[maxEmployees-1] = null;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void showAll() {
        for(int i = 0; i < maxEmployees; i++) {
            if(employees[i] != null) {
                System.out.println(employees[i].getId() + " " + employees[i].getFirstName() + " " + employees[i].getLastName());
            }
        }
    }

    public int getMaxElements() {
        return maxEmployees;
    }
}
