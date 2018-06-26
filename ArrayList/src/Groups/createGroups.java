package Groups;

import Employees.Assistant;
import Employees.Doctor;
import Employees.Senior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class createGroups {
    public static List<groups> createGroups(List<Doctor> doctors, List<Assistant> assistant, List<Senior> Senior){
       boolean failed = true;
        List<groups> groupings;
        //do {
            //create a new arraylist for the Groups.groups to be stored i
            groupings = new ArrayList<>();

            //creting six Groups.groups
            for (int i = 0; i < 6; i++) {
                //if no employee can be found, fill with no docs
                String doc1 = "No Docs";
                String ass1 = "No Assistants";
                String ass2 = "No Assistants";
                String sen1 = "No Senior Assistants";
                int males = 0;
                int females = 0;
                String docGender = "";
                String assistantGender = "";

                //for every doctor which is in the doctor file
                for (Doctor j : doctors) {
                    if (j.gender.equals("Male") && j.inGroup.equals(false) && j.position.equals("Doctor")) {
                        //add their id and name to the group
                        doc1 = j.id + " : " + j.name;
                        j.inGroup = true;
                        males++;
                        docGender = "Male";
                        break;
                    } else if (j.gender.equals("Female") && j.inGroup.equals(false) && j.position.equals("Doctor")) {
                        doc1 = j.id + " : " + j.name;
                        j.inGroup = true;
                        females++;
                        break;
                    }

                }
                //picking assistant
                for (Assistant k : assistant) {
                        if (k.gender.equals("Female") && k.inGroup.equals(false) && k.position.equals("Assistant") && females < 2) {
                            ass1 = k.id + "  : " + k.name;
                            k.inGroup = true;
                            females++;
                            break;
                    }

                    else if (k.gender.equals("Male") && k.inGroup.equals(false) && k.position.equals("Assistant") && males < 2) {
                        ass1 = k.id + " : " + k.name;
                        k.inGroup = true;
                        males++;
                        assistantGender = "Male";
                        break;
                    }

                }
                //picking assistant2
                for (Assistant l : assistant) {
                    if(assistantGender == "Male"){
                        if (l.gender.equals("Female") && l.inGroup.equals(false) && l.position.equals("Assistant") && females < 2) {
                            ass2 = l.id + "  : " + l.name;
                            l.inGroup = true;
                            females++;
                            break;
                    }

                    } else if (l.gender.equals("Male") && l.inGroup.equals(false) && l.position.equals("Assistant") && males < 2) {
                        ass2 = l.id + " : " + l.name;
                        l.inGroup = true;
                        males++;
                        assistantGender = "Male";
                        break;
                    }

                }
                //senior
                for (Senior m : Senior) {
                    if(docGender == "Male") {
                        if (m.gender.equals("Female") && m.inGroup.equals(false) && m.position.equals("Senior") && females < 2) {
                            sen1 = m.id + "  : " + m.name;
                            m.inGroup = true;
                            females++;
                            break;
                        }

                    } else if (m.gender.equals("Male") && m.inGroup.equals(false) && m.position.equals("Senior") && males < 2) {
                        sen1 = m.id + " : " + m.name;
                        m.inGroup = true;
                        males++;
                        break;
                    }
                }

                //add the staff members to the new group
                groupings.add(new groups(doc1, ass1, ass2, sen1));

            }
            //for(groups i : groupings){
             //   if(i.sen1 == "No Senior Assistants" || i.ass1 == "No Senior Assistants" || i.ass2 == "No Senior Assistants" || i.doc1 == "No Docs"){
             //       failed = true;
             //       Collections.shuffle(doctors);
             //       Collections.shuffle(assistant);
              //      Collections.shuffle(Senior);
              //  }
              //  else{
              //      failed = false;
              //  }
           // }
        //}while(failed = true);


        return groupings;
    }

    public static void printGroups(List<groups> groupings){
        int groupNumber = 1;

        for(groups i : groupings){
            System.out.println("Group" + groupNumber);
            System.out.println(i.doc1);
            System.out.println(i.ass1);
            System.out.println(i.ass2);
            System.out.println(i.sen1);
            groupNumber++;
            System.out.println(" ");
        }
    }
}
