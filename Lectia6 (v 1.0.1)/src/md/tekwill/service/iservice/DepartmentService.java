package md.tekwill.service.iservice;

import md.tekwill.domain.Department;
import md.tekwill.domain.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse create(Department department);

    DepartmentResponse read(int departmentId);

    DepartmentResponse update(int departmentId, Department updatedDepartment);

    DepartmentResponse delete(int departmentId);
}
