package md.tekwill.main.console;

// make service !!!
// work with arraylist
// create UI

import md.tekwill.service.impl.DepartmentServiceImpl;
import md.tekwill.service.impl.EmployeeServiceImpl;

public class Main {

    public static void main(String[] args) {

        // Department + Employee Service
        DepartmentServiceImpl dsi = new DepartmentServiceImpl();
        EmployeeServiceImpl esi = new EmployeeServiceImpl();

        showDepartmentsArray(dsi);
        showEmployeesArray(esi);

        String[] helper;


        // DEPARTMENTS
        // -----------

//        // CREATE fail (no name)
//        helper = dsi.create(new Department(""));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // CREATE fail (same name)
//        helper = dsi.create(new Department("IT"));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // CREATE success
//        helper = dsi.create(new Department("Tinkerbell"));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }
//
//        // CREATE fail (not space in array)
//        helper = dsi.create(new Department("Tinkerbell"));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // READ fail (no such ID)
//        helper = dsi.read(12);
//        if(Boolean.parseBoolean(helper[0])) {
//            System.out.println("Elementul cautat este :");
//            System.out.println(helper[1] + " " + helper[1]);
//            System.out.println();
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // READ success
//        helper = dsi.read(2);
//        if(Boolean.parseBoolean(helper[0])) {
//            System.out.println("Elementul cautat este :");
//            System.out.println(helper[1] + " " + helper[2]);
//            System.out.println();
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE fail (no name)
//        helper = dsi.update(12, new Department(""));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE fail (no such ID)
//        helper = dsi.update(12, new Department("Rock"));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE fail (existing department)
//        helper = dsi.update(2, new Department("IT"));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE success
//        helper = dsi.update(2, new Department("Kite"));
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // DELETE fail (no such ID)
//        helper = dsi.delete(12);
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // DELETE success
//        helper = dsi.delete(4);
//        if(Boolean.parseBoolean(helper[0])) {
//            showDepartmentsArray(dsi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }


        // EMPLOYEES
        // ---------

//        // CREATE fail (no department)
//        helper = esi.create(new Employee("Ion", "Barca", new Department("")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // CREATE fail (wrong department)
//        helper = esi.create(new Employee("Ion", "Barca", new Department("Haruka")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // CREATE fail (no name)
//        helper = esi.create(new Employee("", "Barca", new Department("IT")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // CREATE success
//        helper = esi.create(new Employee("Ala", "Barca", new Department("IT")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }
//
//
//        // CREATE fail (no space)
//        helper = esi.create(new Employee("Tina", "Barca", new Department("HR")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // READ fail (no such ID)
//        helper = esi.read(12);
//        if(Boolean.parseBoolean(helper[0])) {
//            System.out.println("Elementul cautat este :");
//            System.out.println(helper[1] + " " + helper[1] + " " + helper[3] + " " + helper[4]);
//            System.out.println();
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // READ success
//        helper = esi.read(2);
//        if(Boolean.parseBoolean(helper[0])) {
//            System.out.println("Elementul cautat este :");
//            System.out.println(helper[1] + " " + helper[2] + " " + helper[3] + " / dpt " + helper[4]);
//            System.out.println();
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE fail (no such ID)
//        helper = esi.update(12, new Employee("Ana", "Pulpa", new Department("PR")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE fail (no dpt)
//        helper = esi.update(2, new Employee("Ana", "Pulpa", new Department("")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE fail (not valid dpt)
//        helper = esi.update(2, new Employee("Ana", "Pulpa", new Department("FFRR")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE fail (no name)
//        helper = esi.update(2, new Employee("Rodica", "", new Department("PR")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // UPDATE success
//        helper = esi.update(2, new Employee("Rodica", "Papura", new Department("PR")));
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // DELETE fail
//        helper = esi.delete(12);
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }

//        // DELETE success
//        helper = esi.delete(2);
//        if(Boolean.parseBoolean(helper[0])) {
//            showEmployeesArray(esi);
//        } else {
//            System.out.println(helper[1]);
//            System.out.println();
//        }
    }

    public static void showDepartmentsArray(DepartmentServiceImpl dsi) {

        String[][] da = dsi.getAll();

        for (String[] x : da) {
            System.out.println(x[0] + " " + x[1]);
        }

        System.out.println();
    }

    public static void showEmployeesArray(EmployeeServiceImpl esi) {

        String[][] da = esi.getAll();

        for (String[] x : da) {
            System.out.println(x[0] + " " + x[1] + " " + x[2] + " / " + x[3] + " dpt");
        }

        System.out.println();
    }
}
