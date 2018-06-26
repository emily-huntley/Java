package Employees;

public abstract class Employee{
        public String name;
        public String gender;
        public String id;
        public Boolean inGroup;
        public String position;

        public String getPosition() { return position; }

        public String getName() { return name; }

        public String getGender() {
            return gender;
        }

        public String getId() {
            return id;
        }


    }
