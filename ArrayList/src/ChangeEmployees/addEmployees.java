package ChangeEmployees;

import Employees.Assistant;
import Employees.Doctor;
import Employees.Senior;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addEmployees {
    //adding a doctor
    public static void addDoctors(String name, String gender, String id, String position){
        String openFile = "C:\\Users\\stephen\\Desktop\\python\\Java\\ArrayList\\Doctor.txt";

        //reload the doctors list
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

        //add the new doctor
        doctors.add(new Doctor(name, gender, id, position));

        //save the new list
        //remove the old employee information file for doctors
        File update = new File(openFile);
        update.delete();

        //create a new file for doctor information
        try {
            update.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //fill out the doctor information with the new doctor information
        try {
            PrintStream setData = new PrintStream(openFile);
            System.setOut(setData);
            int i = 0;
            for (Object s : doctors) {
                System.out.println(doctors.get(i).name + "," + doctors.get(i).gender + "," + doctors.get(i).id + "," + doctors.get(i).position);
                i++;
            }
            //close the new file
            setData.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //change the output from the file back to the console
        PrintStream consoleStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(consoleStream);
    }
    //adding an assistant
    public static void addAssistant(String name, String gender, String id, String position){
        String openFile = "C:\\Users\\stephen\\Desktop\\python\\Java\\ArrayList\\Assistant.txt";

        //reload the doctors list
        List<Assistant> assistant = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(openFile));

            for (String line : allLines) {
                List<String> tmp = Arrays.asList(line.split(","));
                System.out.println(tmp);
                assistant.add(new Assistant(tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add the new doctor
        assistant.add(new Assistant(name, gender, id, position));

        //save the new list
        //remove the old employee information file for doctors
        File update = new File(openFile);
        update.delete();

        //create a new file for doctor information
        try {
            update.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //fill out the doctor information with the new doctor information
        try {
            PrintStream setData = new PrintStream(openFile);
            System.setOut(setData);
            int i = 0;
            for (Object s : assistant) {
                System.out.println(assistant.get(i).name + "," + assistant.get(i).gender + "," + assistant.get(i).id + "," + assistant.get(i).position);
                i++;
            }
            //close the new file
            setData.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //change the output from the file back to the console
        PrintStream consoleStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(consoleStream);
    }
    public static void addSenior(String name, String gender, String id, String position){
        String openFile = "C:\\Users\\stephen\\Desktop\\python\\Java\\ArrayList\\Senior.txt";

        //reload the doctors list
        List<Senior> seniors = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(openFile));

            for (String line : allLines) {
                List<String> tmp = Arrays.asList(line.split(","));
                System.out.println(tmp);
                seniors.add(new Senior(tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add the new doctor
        seniors.add(new Senior(name, gender, id, position));

        //save the new list
        //remove the old employee information file for doctors
        File update = new File(openFile);
        update.delete();

        //create a new file for doctor information
        try {
            update.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //fill out the doctor information with the new doctor information
        try {
            PrintStream setData = new PrintStream(openFile);
            System.setOut(setData);
            int i = 0;
            for (Object s : seniors) {
                System.out.println(seniors.get(i).name + "," + seniors.get(i).gender + "," + seniors.get(i).id + "," + seniors.get(i).position);
                i++;
            }
            //close the new file
            setData.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //change the output from the file back to the console
        PrintStream consoleStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(consoleStream);
    }
}
