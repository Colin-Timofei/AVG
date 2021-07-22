package md.tekwill.dao.idao;
import md.tekwill.domain.Department;

public interface DepartmentDao {


    // CRUD

    Department create(Department newDepartment);

    Department read(int departmentId);

    Department read(String departmentName);

    boolean update(int departmentId, Department updatedDepartment);

    boolean delete(int departmentId);


    // additional

    int findFirstEmptyPosition();

    int findPositionById(int departmentId);

    int findPositionByName(String departmentName);

    Department[] getDepartments();

    int getMaxElements();
}
