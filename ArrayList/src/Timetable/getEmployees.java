package Timetable;

import Groups.groups;

import java.util.List;

public class getEmployees {
    public static Object[] getEmployees(int grp, List<groups> groupings){
        Object[] employees = new Object[4];
        for(groups i : groupings) {
            if (groupings.indexOf(i)==grp) {
                employees[0] = i.doc1;
                employees[1] = i.ass1;
                employees[2] = i.ass2;
                employees[3] = i.sen1;
            }
        }
        return employees;
    }
}
