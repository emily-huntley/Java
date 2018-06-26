package Timetable;

import java.util.Random;

public class createTimetable {
    public static int[][] createTimetable() {

        int[][] Groups = new int[6][3];
        int[][] Shifts = new int[7][3];
        int attempts = 0;
        int daysOfWeek = 7;
        int shiftsInDay = 3;

        do {
            //Error checking for shifts counts.
            //Groups[0][0] is the group number
            //Groups[0][1] is the shifts worked in a row by the group
            //Groups[0][2] is the total shifts worked by the group

            Groups[0][0] = 1;
            Groups[0][1] = 0;
            Groups[0][2] = 0;

            Groups[1][0] = 2;
            Groups[1][1] = 0;
            Groups[1][2] = 0;

            Groups[2][0] = 3;
            Groups[2][1] = 0;
            Groups[2][2] = 0;

            Groups[3][0] = 4;
            Groups[3][1] = 0;
            Groups[3][2] = 0;

            Groups[4][0] = 5;
            Groups[4][1] = 0;
            Groups[4][2] = 0;

            Groups[5][0] = 6;
            Groups[5][1] = 0;
            Groups[5][2] = 0;

            //assign the employees to shifts in each day
            for (int i = 0; i < daysOfWeek; i++) {
                for (int j = 0; j < shiftsInDay; j++) {
                    Random r = new Random();
                    int Low = 0;
                    int High = 6;
                    int Result = r.nextInt(High - Low) + Low;
                    Shifts[i][j] = Groups[Result][0];
                    Groups[Result][1] = Groups[Result][1] + 1;
                    Groups[Result][2] = Groups[Result][2] + 1;

                    while (Groups[Result][1] > 3) {
                        Groups[Result][1] = Groups[Result][1] - 1;
                        Groups[Result][2] = Groups[Result][2] - 1;
                        Result = r.nextInt(High - Low) + Low;
                        Shifts[i][j] = Groups[Result][0];
                        Groups[Result][1] = Groups[Result][1] + 1;
                        Groups[Result][2] = Groups[Result][2] + 1;
                    }

                    if (j == 1) {
                        while (Shifts[i][j] == Shifts[i][0]) {
                            Groups[Result][1] = Groups[Result][1] - 1;
                            Groups[Result][2] = Groups[Result][2] - 1;
                            Result = r.nextInt(High - Low) + Low;
                            Shifts[i][j] = Groups[Result][0];
                            Groups[Result][1] = Groups[Result][1] + 1;
                            Groups[Result][2] = Groups[Result][2] + 1;
                        }
                    } else if (j == 2) {
                        while (Shifts[i][j] == Shifts[i][0] || Shifts[i][j] == Shifts[i][1]) {
                            Groups[Result][1] = Groups[Result][1] - 1;
                            Groups[Result][2] = Groups[Result][2] - 1;
                            Result = r.nextInt(High - Low) + Low;
                            Shifts[i][j] = Groups[Result][0];
                            Groups[Result][1] = Groups[Result][1] + 1;
                            Groups[Result][2] = Groups[Result][2] + 1;
                        }
                    }
                }

                //check if each group has been included in this days shifts patterns
                boolean a = contains(Shifts[i], 1);
                boolean b = contains(Shifts[i], 2);
                boolean c = contains(Shifts[i], 3);
                boolean d = contains(Shifts[i], 4);
                boolean e = contains(Shifts[i], 5);
                boolean f = contains(Shifts[i], 6);

                //if the group number did appear, then reset their days in a row counter to 0
                if (a == false) {
                    Groups[0][1] = 0;
                }
                if (b == false) {
                    Groups[1][1] = 0;
                }
                if (c == false) {
                    Groups[2][1] = 0;
                }
                if (d == false) {
                    Groups[3][1] = 0;
                }
                if (e == false) {
                    Groups[4][1] = 0;
                }
                if (f == false) {
                    Groups[5][1] = 0;
                }
            }

            attempts += 1;

            //if the system has created 10000000 timetables and none of them fit the criteria, then end the program
            if (attempts == 10000000) {
                System.out.println(" ");
                System.out.println("Error in creating a solution");
                System.exit(0);
            }
        }
        //check no group has worked more than 4 shifts in the week.
        //If a group has worked more than 4 shifts, restart the generator
        while (Groups[0][2] > 4 || Groups[1][2] > 4 || Groups[2][2] > 4 || Groups[3][2] > 4 || Groups[4][2] > 4 || Groups[5][2] > 4
                );

        return Shifts;
    }
    private static boolean contains(int[] arr, int item) {
        for (int n : arr){
            if (item == n) {
                return true;
            }
        }
        return false;
    }
}
