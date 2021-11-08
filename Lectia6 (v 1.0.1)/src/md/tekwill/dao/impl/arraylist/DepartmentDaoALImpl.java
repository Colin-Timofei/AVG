package md.tekwill.dao.impl.arraylist;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;

import static md.tekwill.dao.helper.validator.Validator.*;
import static md.tekwill.dao.helper.generator.Generator.*;

import java.util.ArrayList;

public class DepartmentDaoALImpl implements DepartmentDao {

    private static ArrayList<Department> departments = new ArrayList<Department>();

    static {
        generateDepartments(departments);
    }

    @Override
    public Department create(Department newDepartment) throws Exception {

        if(checkInsert(departments.size(), maxDepartments) && validateDepartment(newDepartment)) {
            departments.add(newDepartment);
            return read(newDepartment.getId());
        }

        return null;
    }

    @Override
    public Department read(int departmentId) throws Exception {

        if(validateDepartmentID(departmentId)) {
            for (Department x : departments) {
                if(x.getId() == departmentId) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public Department read(String departmentName) throws Exception {

        if(validateDepartmentName(departmentName)) {
            for (Department x : departments) {
                if(x.getName().equals(departmentName)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public Department update(int departmentId, Department updatedDepartment) throws Exception {

        if(validateDepartmentID(departmentId) && validateDepartment(updatedDepartment)) {
//            read(departmentId).updateDepartment(updatedDepartment);
            return read(departmentId);
        }

        return null;
    }

    @Override
    public boolean delete(int departmentId) throws Exception {

        if (validateDepartmentID(departmentId)) {
            if(read(departmentId) != null) {
                departments.remove(read(departmentId));
                return true;
            }
        }
        return false;
    }

    public Department[] getDepartments() {

        return departments.toArray(new Department[0]);
    }
}
