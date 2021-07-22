package md.tekwill.service.iservice;

import md.tekwill.domain.Employee;

public interface EmployeeService {
    String[] create(Employee employee);

    String[] read(int employeeId);

    String[] update(int employeeId, Employee updatedEmployee);

    String[] delete(int employeeId);
}
