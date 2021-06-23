package Assignment12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentManagement {

    private List<Student> students;

    public StudentManagement(List<Student> students){
        this.students = students;
    }

    public void printAllEngineeringDepartments()
    {
        this.students.stream()
                .map(student -> student.getEngineeringDepartment())
                .distinct()
                .forEach(System.out::println);
    }

    public List<String> joinedAfterEnrollmentYear(int year)
    {
        return this.students.stream()
                .filter(student -> student.getYearOfEnrollment() == year)
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

    public List<Student> filterByGenderAndDepartment(String gender, String engineeringDepartment)
    {
        return this.students.stream()
                .filter(student -> student.getGender().equals(gender))
                .filter(student -> student.getEngineeringDepartment().equals(engineeringDepartment))
                .collect(Collectors.toList());
    }

    public Map<String, Long> countBasedOnGender()
    {
        return this.students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getGender(),
                        Collectors.counting()
                ));
    }

    public Map<String, Double> averageAgeByGender()
    {
        return this.students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getGender(),
                        Collectors.averagingInt(Student::getAge)
                ));
    }

    public Student getDetailsOfHighestPercentage()
    {
        return this.students.stream()
                .filter(student ->
                        student.getPercentageTillDate()
                                ==
                        this.students.stream()
                                .mapToDouble(student1 -> student1.getPercentageTillDate())
                                .max().getAsDouble()
                )
                .collect(Collectors.toList())
                .get(0);
    }

    public Map<String, Long> countBasedOnDepartments()
    {
        return this.students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getEngineeringDepartment(),
                        Collectors.counting()
                ))
                ;
    }

    public Map<String, Long> countByGenderBasedOnDepartments(String department)
    {
        return this.students.stream()
                .filter(student -> student.getEngineeringDepartment().equals(department))
                .collect(Collectors.groupingBy(
                        student -> student.getGender(),
                        Collectors.counting()
                ));
    }

    public Map<String, Double> averageBasedOnDepartment()
    {
        return this.students.stream()
                .collect(Collectors.groupingBy(
                   student -> student.getEngineeringDepartment(),
                   Collectors.averagingDouble(Student::getPercentageTillDate)
                ));
    }

    public Student findYoungestBasedOnGenderAndDepartment(String gender, String department)
    {
        return this.students.stream()
                .filter(student -> student.getGender().equals(gender))
                .filter(student -> student.getEngineeringDepartment().equals(department))
                .collect(Collectors.minBy(
                        (x, y) -> x.getYearOfEnrollment() - y.getYearOfEnrollment()
                )).get();
    }
}
