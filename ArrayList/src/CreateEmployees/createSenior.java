package CreateEmployees;

import Employees.Senior;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class createSenior {
    public static List<Senior> createSenior(){

        //Read the file for Employees.Senior
        String openFileSenior = "C:\\Users\\stephen\\Desktop\\python\\Java\\ArrayList\\Senior.txt";

        //create the Employees.Senior
        List<Senior> Senior = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(openFileSenior));

            for (String line : allLines) {
                List<String> tmp = Arrays.asList(line.split(","));
                System.out.println(tmp);
                Senior.add(new Senior(tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Senior;
    }
}
