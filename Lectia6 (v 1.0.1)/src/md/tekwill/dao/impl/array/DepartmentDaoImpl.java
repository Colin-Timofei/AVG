package md.tekwill.dao.impl.array;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;

import java.util.Arrays;

import static md.tekwill.dao.validator.Validator.*;
import static md.tekwill.dao.generator.Generator.*;


public class DepartmentDaoImpl implements DepartmentDao {

    private static int arraySize = 0;
    private static Department[] departments = new Department[maxDepartments];

    static {
        generateDepartments(departments);

        for(int i = 0; i < maxDepartments; i++) {
            if(departments[i] != null) {
                arraySize++;
            }
        }
    }

    @Override
    public Department create(Department newDepartment) throws Exception {

        if(checkInsert(arraySize, maxDepartments) && validateDepartment(newDepartment)) {
            for(Department x : departments) {
                if(x == null) {
                    x = newDepartment;
                    arraySize++;
                    return read(newDepartment.getId());
                }
            }
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
            read(departmentId).updateDepartment(updatedDepartment);
            return read(departmentId);
        }

        return null;
    }

    @Override
    public boolean delete(int departmentId) throws Exception {

        if (validateDepartmentID(departmentId)) {
            for (int i = 0; i < maxDepartments; i++) {
                if(departments[i] != null && departments[i].getId() == departmentId) {
                    moveToRightFromPosition(i);
                    arraySize--;
                    return true;
                }
            }
        }
        return false;
    }

    private void moveToRightFromPosition(int position) {

        for(int i = position; i < maxDepartments-1; i++)  {
            departments[i] = departments[i+1];
        }

        departments[maxDepartments-1] = null;
    }

    public Department[] getDepartments() {
        return Arrays.copyOfRange(departments, 0, arraySize-1);
    }
}