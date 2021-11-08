package md.tekwill.dao.helper.file;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogWriter implements IDTF {

    public static void writeToTxt(ArrayList<Department> ad, ArrayList<Employee> ae) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {

            writer.write("Log added on : ");
            writer.write(String.valueOf(LocalDateTime.now().format(formatter)));
            writer.newLine();
            writer.write("-----------------------------------");
            writer.newLine();
            writer.newLine();

            if(ad.size() != 0) {

                writer.write("Departments");
                writer.newLine();
                writer.write("-----------");
                writer.newLine();
                writer.newLine();

                for(Department tmp : ad) {
                    writer.write("ID : " + tmp.getId());
                    writer.newLine();
                    writer.write("Name : " + tmp.getName());
                    writer.newLine();
                    writer.write("Created : " + tmp.getCreatedAt().format(formatter));
                    writer.newLine();
                    writer.write("Updated : " + tmp.getLastUpdated().format(formatter));
                    writer.newLine();
                    writer.newLine();
                }
            }

            if(ae.size() != 0) {
                writer.write("Employees");
                writer.newLine();
                writer.write("---------");
                writer.newLine();
                writer.newLine();

                for(Employee tmp : ae) {
                    writer.write("ID : " + tmp.getId());
                    writer.newLine();
                    writer.write("First name : " + tmp.getFirstName());
                    writer.newLine();
                    writer.write("Last name : " + tmp.getLastName());
                    writer.newLine();
                    writer.write("Department : " + tmp.getDepartment().getName());
                    writer.newLine();
                    writer.write("Created : " + tmp.getCreatedAt().format(formatter));
                    writer.newLine();
                    writer.write("Updated : " + tmp.getLastUpdated().format(formatter));
                    writer.newLine();
                    writer.newLine();
                }
            }

            writer.newLine();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
