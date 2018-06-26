import java.util.*;

import CreateEmployees.*;
import Employees.*;
import Groups.*;
import Timetable.*;

public class main {

    public static void main(String[] args) {

    //Call for create Doctors
    List<Doctor> doctors;
    doctors = createDoctors.createDoctors();


    //Call for create Assistant
    List<Assistant> assistant;
    assistant = createAssistants.createAssistants();


    //Call for create Seniors
    List<Senior> Senior;
    Senior = createSenior.createSenior();


    //Shuffle the list so Groups.groups can change
    Collections.shuffle(doctors);
    Collections.shuffle(assistant);
    Collections.shuffle(Senior);

    List<groups> groupings;
    groupings = createGroups.createGroups(doctors, assistant, Senior);

    //print out all the Groups.groups
    createGroups.printGroups(groupings);

    //creates your timetable
    int[][]timetable = createTimetable.createTimetable();
    System.out.println(Arrays.deepToString(timetable));

    //for jtables, you need your data in a 2D array, this is set up for weeks on the topbar
    Object data[][] = new Object[3][7];
    Object employeeNames[] = new Object[4];
        //complete for the three shifts
        for (int i = 0; i < 3; i++) {
            //complete for 7 days
            for (int j = 0; j < 7; j++) {
                //get the groups ID from timetable and -1 to account for indexing starting at 0
                int grp = timetable[j][i]-1;
                //test data as I am testing with two groups... get rid of this if statement when 6 or more groups are created
//                if(grp > 1){
//                    grp = 1;
//                }
                //retrieve the correct employees and put them into an array
                employeeNames = getEmployees.getEmployees(grp, groupings);
                //four employees so run the code four times
                for (int k = 0; k < 4; k++) {
                    //if there is no data, add the doctor first with the start HTML tag for styling the data in jTable
                    if(data[i][j] == null){
                        data[i][j] = "<HTML>" + employeeNames[k];
                    }
                    //now add the rest of the employees. The <br> tag starts a new line per employee in the jTable
                    else {
                        String check = data[i][j] + " <br> " + employeeNames[k];
                        data[i][j] = check;
                    }
                }
                //finally, add the closing HTML tag
                data[i][j] = data[i][j] + "</HTML>";
            }
        }
        //print out the timetable with employees
        System.out.println(Arrays.deepToString(data));
    }
}