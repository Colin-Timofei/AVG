package md.tekwill.service.impl;

import md.tekwill.dao.idao.DepartmentDao;
import md.tekwill.dao.impl.array.DepartmentDaoImpl;
import md.tekwill.dao.impl.arraylist.DepartmentDaoALImpl;
import md.tekwill.dao.impl.map.DepartmentDaoMapImpl;
import md.tekwill.domain.Department;
import md.tekwill.domain.DepartmentResponse;
import md.tekwill.main.swing2.main.SwingMain;
import md.tekwill.service.iservice.DepartmentService;

import java.time.format.DateTimeFormatter;

public class DepartmentServiceImpl implements DepartmentService {

    private static DepartmentDao departmentDao;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu kk:mm:ss");

    static {
        switch (SwingMain.variant) {
            case "Array" : departmentDao = new DepartmentDaoImpl(); break;
            case "ArrayList" : departmentDao = new DepartmentDaoALImpl(); break;
            case "Map" : departmentDao = new DepartmentDaoMapImpl(); break;
        }
    }

    public DepartmentResponse create(Department department) {

        DepartmentResponse departmentResponse;

        try {
            Department tmp = departmentDao.create(department);
            if(tmp != null) {
                departmentResponse = new DepartmentResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            departmentResponse = new DepartmentResponse(e);
        }

        return departmentResponse;
    }

    public DepartmentResponse read(int departmentId) {

        DepartmentResponse departmentResponse;

        try {
            Department tmp = departmentDao.read(departmentId);
            if(tmp != null) {
                departmentResponse = new DepartmentResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            departmentResponse = new DepartmentResponse(e);
        }

        return departmentResponse;
    }

    public DepartmentResponse update(int departmentId, Department updatedDepartment) {

        DepartmentResponse departmentResponse;

        try {
            Department tmp = departmentDao.update(departmentId, updatedDepartment);
            if(tmp != null) {
                departmentResponse = new DepartmentResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            departmentResponse = new DepartmentResponse(e);
        }

        return departmentResponse;
    }

    public DepartmentResponse delete(int departmentId) {

        DepartmentResponse departmentResponse;

        try {
            boolean tmp = departmentDao.delete(departmentId);

            if(tmp) {
                departmentResponse = new DepartmentResponse(tmp);
            } else {
                throw new Exception("An error occurred !");
            }
        } catch(Exception e) {
            departmentResponse = new DepartmentResponse(e);
        }

        return departmentResponse;
    }

    public String[][] getAll() {

        Department[] tmp = departmentDao.getDepartments();
        int size = tmp.length;
        String[][] result;


        if(size != 0) {

            result = new String[size][4];

            for(int i = 0; i < size; i++) {
                result[i][0] = String.valueOf(tmp[i].getId());
                result[i][1] = tmp[i].getName();
                result[i][2] = tmp[i].getCreatedAt().format(formatter);
                result[i][3] = tmp[i].getLastUpdated().format(formatter);
            }

            return result;

        }

        return null;
    }

    public String[] getDepartmentNames() {

        Department[] tmp = departmentDao.getDepartments();
        int size = tmp.length;

        String[] result = new String[size];


        for(int i = 0; i < size; i++) {
            result[i] = tmp[i].getName();
        }

        return result;
    }
}