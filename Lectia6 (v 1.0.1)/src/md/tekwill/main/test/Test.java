package md.tekwill.main.test;

import md.tekwill.domain.Department;

import java.util.ArrayList;

public class Test {

    public static void main(String args[])
    {
        ArrayList<Department> arrayList = new ArrayList<>();

        Department department1 = new Department("Unu");
        Department department2 = new Department("Doi");
        Department department3 = new Department("Trei");

        arrayList.add(department1);
        arrayList.add(department3);
        arrayList.add(department2);

        System.out.println(arrayList.get(1).getName());

    }
}