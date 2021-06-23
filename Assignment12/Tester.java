package Assignment12;

import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {

        ArrayList<Student> studentArrayList = new ArrayList<>();

        studentArrayList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentArrayList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentArrayList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentArrayList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentArrayList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentArrayList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentArrayList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentArrayList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentArrayList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentArrayList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentArrayList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentArrayList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentArrayList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentArrayList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentArrayList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentArrayList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentArrayList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        StudentManagement management = new StudentManagement(studentArrayList);

        // 1.  Print the name of all departments in the college?
        management.printAllEngineeringDepartments();

        // 2. Get the names of all students who have enrolled after 2018?
        System.out.println(management.joinedAfterEnrollmentYear(2018));

        // 3. Get the details of all male student in the computer sci department?
        System.out.println(management.filterByGenderAndDepartment("Male", "Computer Science"));

        // 4. How many male and female student are there ?
        System.out.println(management.countBasedOnGender());

        // 5. What is the average age of male and female students?
        System.out.println(management.averageAgeByGender());

        // 6. Get the details of highest student having highest percentage ?
        System.out.println(management.getDetailsOfHighestPercentage());

        // 7. Count the number of students in each department?
        System.out.println(management.countBasedOnDepartments());

        // 8. What is the average percentage achieved in each department?
        System.out.println(management.averageBasedOnDepartment());

        // 9. Get the details of youngest male student in the Electronic department?
        System.out.println(management.findYoungestBasedOnGenderAndDepartment("Male", "Electronic"));

        // 10. How many male and female students are there in the computer science department?
        System.out.println(management.countByGenderBasedOnDepartments("Computer Science"));


    }
}
