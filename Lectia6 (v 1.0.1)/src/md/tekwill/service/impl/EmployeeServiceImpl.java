package md.tekwill.service.impl;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.dao.impl.array.DepartmentDaoImpl;
import md.tekwill.dao.impl.array.EmployeeDaoImpl;
import md.tekwill.dao.impl.arraylist.DepartmentDaoALImpl;
import md.tekwill.dao.impl.arraylist.EmployeeDaoALImpl;
import md.tekwill.dao.impl.map.DepartmentDaoMapImpl;
import md.tekwill.dao.impl.map.EmployeeDaoMapImpl;
import md.tekwill.domain.Employee;
import md.tekwill.service.iservice.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeDao employeeDao= new EmployeeDaoMapImpl();
    private static DepartmentDao departmentDao= new DepartmentDaoMapImpl();

    @Override
    public String[] create(Employee employee) {

        if(employeeDao.findFirstEmptyPosition() == -1) {
            return new String[] {"false", "cannot add more records !"};
        } else if(employee.getDepartment().getName().equals("")) {
            return new String[] {"false", "the employee must belong to a department"};
        } else if (departmentDao.findPositionByName(employee.getDepartment().getName()) == -1) {
            return new String[] {"false", "the employee must belong to an existing department"};
        } else if (employee.getFirstName().equals("") || employee.getLastName().equals("")) {
            return new String[] {"false", "the new employee must have a valid name"};
        } else {
            employeeDao.create(employee);
            return new String[] {"true", "new record created !"};
        }
    }

    @Override
    public String[] read(int employeeId) {

        if(employeeDao.findPositionById(employeeId) == -1) {
            return new String[] {"false", "cannot find an employee with the ID " + employeeId};
        } else {
            Employee tmp = employeeDao.read(employeeId);
            return new String[] {"true", String.valueOf(tmp.getId()), tmp.getFirstName(), tmp.getLastName(), tmp.getDepartment().getName()};
        }
    }

    @Override
    public String[] update(int employeeId, Employee updatedEmployee) {

        if(employeeDao.findPositionById(employeeId) == -1) {
            return new String[] {"false", "cannot find an employee with the ID " + employeeId};
        } else if(updatedEmployee.getDepartment().getName().equals("")) {
            return new String[] {"false", "the employee must belong to a department !"};
        } else if (departmentDao.findPositionByName(updatedEmployee.getDepartment().getName()) == -1) {
            return new String[] {"false", "the employee must belong to an existing department !"};
        } else if (updatedEmployee.getLastName().equals("") || updatedEmployee.getLastName().equals("")) {
            return new String[] {"false", "the new employee must have a valid name !"};
        } else {
            employeeDao.update(employeeId, updatedEmployee);
            return new String[] {"true", "the record had been adjusted !"};
        }
    }

    @Override
    public String[] delete(int employeeId) {
        if(employeeDao.findPositionById(employeeId) == -1) {
            return new String[] {"false", "cannot find an employee with the ID " + employeeId};
        } else {
            employeeDao.delete(employeeId);
            return new String[] {"true", "employee deleted !"};
        }
    }

    public String[][] getAll() {

        int size = employeeDao.findFirstEmptyPosition() == -1 ? employeeDao.getMaxElements() : employeeDao.findFirstEmptyPosition();
        String[][] result = new String[size][4];
        Employee[] temp = employeeDao.getEmployees();

        for(int i = 0; i < size; i++) {
            result[i][0] = String.valueOf(temp[i].getId());
            result[i][1] = temp[i].getFirstName();
            result[i][2] = temp[i].getLastName();
            result[i][3] = temp[i].getDepartment().getName();
        }

        return result;
    }
}