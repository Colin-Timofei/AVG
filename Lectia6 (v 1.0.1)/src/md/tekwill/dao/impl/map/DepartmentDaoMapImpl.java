package md.tekwill.dao.impl.map;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;
import md.tekwill.generator.MapGenerator;

import java.util.HashMap;

public class DepartmentDaoMapImpl implements DepartmentDao {

    private final static int maxDepartments = 15;
    private static HashMap<Integer, Department> departments = new HashMap<Integer, Department>();

    static {
        MapGenerator.generateDepartments(departments);
    }

    @Override
    public Department create(Department newDepartment) {

        int position = findFirstEmptyPosition();

        if(position != -1) {
            departments.put(newDepartment.getId(), newDepartment);
            return newDepartment;
        }

        return null;
    }

    @Override
    public Department read(int departmentId) {

        int position = findPositionById(departmentId);

        if(position != -1) {
            for (Department x : departments.values()) {
                if (x.getId() == departmentId) {
                    return x;
                }
            }
        }

        return null;
    }

    @Override
    public Department read(String departmentName) {

        int position = findPositionByName(departmentName);

        if(position != -1) {
            for(Department x : departments.values()) {
                if (x.getName().equals(departmentName)) {
                    return x;
                }
            }
        }

        return null;
    }

    @Override
    public boolean update(int departmentId, Department updatedDepartment) {

        int position = findPositionById(departmentId);

        if(position == -1) {
            return false;
        }
        else {
            departments.get(departmentId).setName(updatedDepartment.getName());
            return true;
        }
    }

    @Override
    public boolean delete(int departmentId) {

        int position = findPositionById(departmentId);

        if (position == -1) {
            return false;
        } else {
            departments.remove(departmentId);
            return true;
        }
    }

    @Override
    public int findFirstEmptyPosition() {

        return departments.size() < maxDepartments ? departments.size() : -1;
    }

    @Override
    public int findPositionById(int departmentId) {

        for(Department x : departments.values()) {
            if (x.getId() == departmentId) {
                return -2;
            }
        }

        return -1;
    }

    @Override
    public int findPositionByName(String departmentName) {

        for(Department x : departments.values()) {
            if(x.getName().equals(departmentName))
                return -2;
        }

        return -1;
    }

    @Override
    public Department[] getDepartments() {

        int i = 0;
        Department[] tmp = new Department[departments.size()];

        for(Department x : departments.values()) {
            tmp[i++] = x;
        }

        return tmp;
    }

    @Override
    public int getMaxElements() {
        return maxDepartments;
    }
}