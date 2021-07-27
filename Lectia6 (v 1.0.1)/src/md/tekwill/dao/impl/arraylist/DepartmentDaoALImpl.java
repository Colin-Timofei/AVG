package md.tekwill.dao.impl.arraylist;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;
import md.tekwill.generator.ArrayListGenerator;

import java.util.ArrayList;

public class DepartmentDaoALImpl implements DepartmentDao {

    private final static int maxDepartments = 15;
    private static ArrayList<Department> departments = new ArrayList<Department>();

    static {
        ArrayListGenerator.generateDepartments(departments);
    }

    @Override
    public Department create(Department newDepartment) {

        int position = findFirstEmptyPosition();

        if(position == -1) {
            return null;
        }
        else {
            departments.add(newDepartment);
            return departments.get(position);
        }
    }

    @Override
    public Department read(int departmentId) {

        int position = findPositionById(departmentId);

        if(position == -1) {
            return null;
        }
        else {
            return departments.get(position);
        }
    }

    @Override
    public Department read(String departmentName) {

        int position = findPositionByName(departmentName);

        if(position == -1) {
            return null;
        }
        else {
            return departments.get(position);
        }
    }

    @Override
    public boolean update(int departmentId, Department updatedDepartment) {

        int position = findPositionById(departmentId);

        if(position == -1) {
            return false;
        }
        else {
            departments.get(position).setName(updatedDepartment.getName());
            return true;
        }
    }

    @Override
    public boolean delete(int departmentId) {

        int position = findPositionById(departmentId);

        if (position == -1) {
            return false;
        } else {
            departments.remove(position);
            return true;
        }
    }

    @Override
    public int findFirstEmptyPosition() {

        return departments.size() < maxDepartments ? departments.size() : -1;
    }

    @Override
    public int findPositionById(int departmentId) {

        for(Department x : departments) {
            if (x.getId() == departmentId) {
                return departments.indexOf(x);
            }
        }

        return -1;
    }

    @Override
    public int findPositionByName(String departmentName) {

        for(Department x : departments) {
            if (x.getName().equals(departmentName)) {
                return departments.indexOf(x);
            }
        }

        return -1;
    }

    @Override
    public Department[] getDepartments() {

        int size = departments.size();
        Department[] tmp = new Department[size];

        for(int i = 0; i < size; i++) {
            tmp[i] = departments.get(i);
        }

        return tmp;
    }

    @Override
    public int getMaxElements() {
        return maxDepartments;
    }
}
