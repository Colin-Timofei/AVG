package md.tekwill.service.impl;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.dao.idao.EmployeeDao;
import md.tekwill.dao.impl.array.DepartmentDaoImpl;
import md.tekwill.dao.impl.array.EmployeeDaoImpl;
import md.tekwill.dao.impl.arraylist.DepartmentDaoALImpl;
import md.tekwill.dao.impl.arraylist.EmployeeDaoALImpl;
import md.tekwill.dao.impl.map.DepartmentDaoMapImpl;
import md.tekwill.dao.impl.map.EmployeeDaoMapImpl;
import md.tekwill.domain.Department;
import md.tekwill.domain.DepartmentResponse;
import md.tekwill.domain.Employee;
import md.tekwill.domain.EmployeeResponse;
import md.tekwill.main.swing2.main.SwingMain;
import md.tekwill.service.iservice.EmployeeService;

import java.time.format.DateTimeFormatter;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeDao employeeDao;
    private static DepartmentDao departmentDao;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu kk:mm:ss");

    static {
        switch (SwingMain.variant) {
            case "Array" : departmentDao = new DepartmentDaoImpl();
                employeeDao = new EmployeeDaoImpl(); break;
            case "ArrayList" : departmentDao = new DepartmentDaoALImpl();
                employeeDao = new EmployeeDaoALImpl(); break;
            case "Map" : departmentDao = new DepartmentDaoMapImpl();
                employeeDao = new EmployeeDaoMapImpl(); break;
        }
    }

    @Override
    public EmployeeResponse create(Employee employee) {

        EmployeeResponse employeeResponse;

        try {
            Employee tmp = employeeDao.create(employee);
            if(tmp != null) {
                employeeResponse = new EmployeeResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            employeeResponse = new EmployeeResponse(e);
        }

        return employeeResponse;
    }

    @Override
    public EmployeeResponse read(int employeeId) {

        EmployeeResponse employeeResponse;

        try {
            Employee tmp = employeeDao.read(employeeId);
            if(tmp != null) {
                employeeResponse = new EmployeeResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            employeeResponse = new EmployeeResponse(e);
        }

        return employeeResponse;
    }

    @Override
    public EmployeeResponse update(int employeeId, Employee updatedEmployee) {

        EmployeeResponse employeeResponse;

        try {
            Employee tmp = employeeDao.update(employeeId, updatedEmployee);
            if(tmp != null) {
                employeeResponse = new EmployeeResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            employeeResponse = new EmployeeResponse(e);
        }

        return employeeResponse;
    }

    @Override
    public EmployeeResponse delete(int employeeId) {

        EmployeeResponse employeeResponse;

        try {
            boolean tmp = employeeDao.delete(employeeId);

            if(tmp) {
                employeeResponse = new EmployeeResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            employeeResponse = new EmployeeResponse(e);
        }

        return employeeResponse;
    }

    public String[][] getAll() {

        Employee[] tmp = employeeDao.getEmployees();
        int size = tmp.length;
        String[][] result;


        if(size != 0) {

            result = new String[size][6];

            for(int i = 0; i < size; i++) {
                result[i][0] = String.valueOf(tmp[i].getId());
                result[i][1] = tmp[i].getFirstName();
                result[i][2] = tmp[i].getLastName();
                result[i][3] = tmp[i].getDepartment().getName();
                result[i][4] = tmp[i].getCreatedAt().format(formatter);
                result[i][5] = tmp[i].getLastUpdated().format(formatter);
            }

            return result;

        }

        return null;
    }
}