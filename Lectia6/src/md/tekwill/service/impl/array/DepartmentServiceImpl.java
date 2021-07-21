package md.tekwill.service.impl.array;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.dao.impl.array.DepartmentDaoImpl;
import md.tekwill.domain.Department;
import md.tekwill.service.iservice.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

    private static DepartmentDao departmentDao= new DepartmentDaoImpl();

    public String[] create(Department department) {

        if(department.getName().equals("")) {
            return new String[] {"false", "the new department should have a name !"};
        } else if(departmentDao.findFirstEmptyPosition() == -1) {
            return new String[] {"false", "cannot add more records !"};
        } else if (departmentDao.findPositionByName(department.getName()) != -1) {
            return new String[] {"false", department.getName() + " department already exists !"};
        } else {
            departmentDao.create(department);
            return new String[] {"true", "new record created !"};
        }
    }

    public String[] read(int departmentId) {

        if(departmentDao.findPositionById(departmentId) == -1) {
            return new String[] {"false", "cannot find a department with the ID " + departmentId};
        } else {
            Department tmp = departmentDao.read(departmentId);
            return new String[] {"true", String.valueOf(tmp.getId()), tmp.getName()};
        }
    }

    public String[] update(int departmentId, Department updatedDepartment) {

        if (updatedDepartment.getName().equals("")) {
            return new String[] {"false", "the department should have a name !"};
        } else if(departmentDao.findPositionById(departmentId) == -1) {
            return new String[] {"false", "cannot find a department with the ID " + departmentId};
        } else if (departmentDao.findPositionByName(updatedDepartment.getName()) != -1) {
            return new String[] {"false", "cannot rename this department because a department named " + updatedDepartment.getName() + " already exists !"};
        } else {
            departmentDao.update(departmentId, updatedDepartment);
            return new String[] {"true", "department updated !"};
        }
    }

    public String[] delete(int departmentId) {
        if(departmentDao.findPositionById(departmentId) == -1) {
            return new String[] {"false", "cannot find a department with the ID " + departmentId};
        } else {
            departmentDao.delete(departmentId);
            return new String[] {"true", "department deleted !"};
        }
    }

    public String[][] getAll() {

        int size = departmentDao.findFirstEmptyPosition() == -1 ? departmentDao.getMaxElements() : departmentDao.findFirstEmptyPosition();
        String[][] result = new String[size][2];
        Department[] temp = departmentDao.getDepartments();

        for(int i = 0; i < size; i++) {
            result[i][0] = String.valueOf(temp[i].getId());
            result[i][1] = temp[i].getName();
        }

        return result;
    }
}