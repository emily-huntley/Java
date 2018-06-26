package ChangeEmployees;

import Employees.Assistant;
import Employees.Doctor;
import Employees.Senior;

import java.util.List;

public class removeEmployees {
    public static void removeDoctors(List<Doctor> doctorList, int remove){
        for (Doctor i : doctorList){
            if(doctorList.indexOf(i) == remove){
                doctorList.remove(i);
            }
        }
    }
    public static void removeAssistant(List<Assistant> assistantList, int remove){
        for (Assistant i : assistantList){
            if(assistantList.indexOf(i) == remove){
                assistantList.remove(i);
            }
        }
    }
    public static void removeSenior(List<Senior> seniorList, int remove){
        for (Senior i : seniorList){
            if(seniorList.indexOf(i) == remove){
                seniorList.remove(i);
            }
        }
    }
}
