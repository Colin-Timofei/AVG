package md.tekwill.dao.idao;

import md.tekwill.domain.Employee;

public interface EmployeeDao {

    public final static int maxEmployees = 50;

    Employee create(Employee employee) throws Exception;

    Employee read(int employeeId) throws Exception;

    Employee update(int employeeId, Employee updatedEmployee) throws Exception;

    boolean delete(int employeeId) throws Exception;

    Employee[] getEmployees();
}
