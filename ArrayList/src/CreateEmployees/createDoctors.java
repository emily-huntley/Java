package CreateEmployees;

import Employees.Doctor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class createDoctors {
    public static List<Doctor> createDoctors(){

        String openFile = "C:\\Users\\stephen\\Desktop\\python\\Java\\ArrayList\\Doctor.txt";

        List<Doctor> doctors = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(openFile));

            for (String line : allLines) {
                List<String> tmp = Arrays.asList(line.split(","));
                System.out.println(tmp);
                doctors.add(new Doctor(tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return doctors;
    }

}
