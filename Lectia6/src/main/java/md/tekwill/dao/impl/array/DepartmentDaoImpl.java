package md.tekwill.dao.impl.array;

import md.tekwill.dao.helper.generator.DepartmentGenerator;
import md.tekwill.dao.helper.updater.Updater;
import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;

import java.util.Arrays;
import java.util.Optional;

import static md.tekwill.dao.helper.validator.DepartmentValidator.*;

public class DepartmentDaoImpl implements DepartmentDao {

    private static int arraySize = 0;
    private static Department[] departments = new Department[maxDepartments];

    static {
        DepartmentGenerator.generateDepartments(departments);

        for(int i = 0; i < maxDepartments; i++) {
            if(departments[i] != null) {
                arraySize++;
            }
        }
    }

    @Override
    public Department create(Department newDepartment) throws Exception {

        if(validateInsert(arraySize, maxDepartments) && validateDepartment(newDepartment)) {
            departments[arraySize++] = newDepartment;
            return read(newDepartment.getId());
        }

        return null;
    }

    @Override
    public Department read(int departmentId) throws Exception {

        if(validateDepartmentID(departmentId)) {

            Optional <Department> optional = Arrays.stream(departments)
                    .filter(x -> x.getId() == departmentId)
                    .findFirst();

            if(optional.isPresent()) {
                return optional.get();
            }
        }

        return null;
    }

    @Override
    public Department read(String departmentName) throws Exception {

        if(validateDepartmentName(departmentName)) {

            Optional <Department> optional = Arrays.stream(departments)
                    .filter(x -> x.getName().equals(departmentName))
                    .findFirst();

            if(optional.isPresent()) {
                return optional.get();
            }
        }

        return null;
    }

    @Override
    public Department update(int departmentId, Department updatedDepartment) throws Exception {

        if(validateDepartmentID(departmentId) && validateDepartment(updatedDepartment)) {
            if(read(departmentId) != null) {
                Updater.update(read(departmentId), updatedDepartment);
                return read(departmentId);
            }
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
