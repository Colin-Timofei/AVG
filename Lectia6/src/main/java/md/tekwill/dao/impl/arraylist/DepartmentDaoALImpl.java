package md.tekwill.dao.impl.arraylist;

import md.tekwill.dao.helper.generator.DepartmentGenerator;
import md.tekwill.dao.helper.updater.Updater;
import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;

import java.util.ArrayList;
import java.util.Optional;

import static md.tekwill.dao.helper.validator.DepartmentValidator.*;

public class DepartmentDaoALImpl implements DepartmentDao {

    private static ArrayList<Department> departments = new ArrayList<Department>();

    static {
        DepartmentGenerator.generateDepartments(departments);
    }

    @Override
    public Department create(Department newDepartment) throws Exception {

        if(validateInsert(departments.size(), maxDepartments) && validateDepartment(newDepartment)) {
            departments.add(newDepartment);
            return read(newDepartment.getId());
        }

        return null;
    }

    @Override
    public Department read(int departmentId) throws Exception {

        if(validateDepartmentID(departmentId)) {

            Optional<Department> optional = departments.stream()
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

            Optional <Department> optional = departments.stream()
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
