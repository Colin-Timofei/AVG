package md.tekwill.dao.idao;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

public interface EmployeeDao {


    // CRUD

    Employee create(Employee employee);

    Employee read(int employeeId);

    boolean update(int employeeId, Employee updatedEmployee);

    boolean delete(int employeeId);

    // additional

    int findFirstEmptyPosition();

    int findPositionById(int employeeId);

    Employee[] getEmployees();

    int getMaxElements();
}
