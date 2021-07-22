package md.tekwill.dao.impl.array;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.domain.Department;
import md.tekwill.generator.array.ArrayGenerator;

public class DepartmentDaoImpl implements DepartmentDao {

    private final static int maxDepartments = 15;
    private static Department[] departments = new Department[maxDepartments];

    static {
        ArrayGenerator.generateDepartments(departments);
    }

    @Override
    public Department create(Department newDepartment) {

        int position = findFirstEmptyPosition();

        if(position == -1) {
            return null;
        }
        else {
            departments[position] = newDepartment;
            return departments[position];
        }
    }

    @Override
    public Department read(int departmentId) {

        int position = findPositionById(departmentId);

        if(position == -1) {
            return null;
        }
        else {
            return departments[position];
        }
    }

    @Override
    public Department read(String departmentName) {

        int position = findPositionByName(departmentName);

        if(position == -1) {
            return null;
        }
        else {
            return departments[position];
        }
    }

    @Override
    public boolean update(int departmentId, Department updatedDepartment) {

        int position = findPositionById(departmentId);

        if(position == -1) {
            return false;
        }
        else {
            departments[position].setName(updatedDepartment.getName());
            return true;
        }
    }

    public boolean delete(int departmentId) {

        int position = findPositionById(departmentId);

        if (position == -1) {
            return false;
        } else {
            moveToRightFromPosition(position);
            return true;
        }
    }

    public int findFirstEmptyPosition() {

        for(int i = 0; i < maxDepartments; i++) {
            if (departments[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int findPositionById(int departmentId) {

        for(int i = 0; i < maxDepartments; i++) {
            if(departments[i] != null && departments[i].getId() == departmentId) {
                return i;
            }
        }
        return -1;
    }

    public int findPositionByName(String departmentName) {

        for(int i = 0; i < maxDepartments; i++) {
            if(departments[i] != null && departments[i].getName().equals(departmentName)) {
                return i;
            }
        }
        return -1;
    }

    private void moveToRightFromPosition(int position) {

        for(int i = position; i < maxDepartments-1; i++)  {
            departments[i] = departments[i+1];
        }

        departments[maxDepartments-1] = null;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void showAll() {

        for(int i = 0; i < maxDepartments; i++) {
            if(departments[i] != null) {
                System.out.println(departments[i].getId() + " " + departments[i].getName());
            }
        }
    }

    public int getMaxElements() {
        return maxDepartments;
    }
}