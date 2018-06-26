package CreateEmployees;

import Employees.Assistant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class createAssistants {
    public static List<Assistant> createAssistants(){
        //Read the file for assistants
        String openFileAss = "C:\\Users\\stephen\\Desktop\\python\\Java\\ArrayList\\Assistant.txt";

        //create the assistants
        List<Assistant> assistant = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(openFileAss));

            for (String line : allLines) {
                List<String> tmp = Arrays.asList(line.split(","));
                System.out.println(tmp);
                assistant.add(new Assistant(tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assistant;
    }
}
