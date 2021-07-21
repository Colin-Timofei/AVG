package md.tekwill.service.iservice;

import md.tekwill.domain.Department;

public interface DepartmentService {

    String[] create(Department department);

    String[] read(int departmentId);

    String[] update(int departmentId, Department updatedDepartment);

    String[] delete(int departmentId);
}
