package md.tekwill.dao.impl.map;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;

import static md.tekwill.dao.helper.validator.Validator.*;
import static md.tekwill.dao.helper.generator.Generator.*;

import java.util.HashMap;

public class DepartmentDaoMapImpl implements DepartmentDao {

    private static HashMap<Integer, Department> departments = new HashMap<Integer, Department>();

    static {
        generateDepartments(departments);
    }

    @Override
    public Department create(Department newDepartment) throws Exception {

        if(checkInsert(departments.size(),maxDepartments) && validateDepartment(newDepartment)) {
            departments.put(newDepartment.getId(), newDepartment);
            return read(newDepartment.getId());
        }

        return null;
    }

    @Override
    public Department read(int departmentId) throws Exception {

        if(validateDepartmentID(departmentId)) {
            return departments.get(departmentId);
        }
        return null;
    }

    @Override
    public Department read(String departmentName) throws Exception {

        if(validateDepartmentName(departmentName)) {
            for (Department x : departments.values()) {
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
                departments.remove(departmentId);
                return true;
            }
        }
        return false;
    }

    public Department[] getDepartments() {

        return departments.values().toArray(new Department[0]);
    }
}