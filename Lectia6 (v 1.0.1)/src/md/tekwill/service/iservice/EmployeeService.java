package md.tekwill.service.iservice;

import md.tekwill.domain.Employee;
import md.tekwill.domain.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse create(Employee employee);

    EmployeeResponse read(int employeeId);

    EmployeeResponse update(int employeeId, Employee updatedEmployee);

    EmployeeResponse delete(int employeeId);
}
