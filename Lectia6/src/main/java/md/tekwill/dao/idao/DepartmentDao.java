package md.tekwill.dao.idao;

import md.tekwill.domain.Department;

public interface DepartmentDao {

    int maxDepartments = 15;

    Department create(Department newDepartment) throws Exception;

    Department read(int departmentId) throws Exception;

    Department read(String departmentName) throws Exception;

    Department update(int departmentId, Department updatedDepartment) throws Exception;

    boolean delete(int departmentId) throws Exception;

    Department[] getDepartments();
}
