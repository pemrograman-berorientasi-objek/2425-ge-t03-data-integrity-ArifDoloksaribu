package academic.driver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import academic.model.Student;
import academic.model.Course;
import academic.model.Enrollment;

public class Driver1 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);
        Set<Course> courses = new HashSet<>();
        Set<Student> students = new HashSet<>();
        Set<Enrollment> enrollments = new HashSet<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] data = input.split("#");

            switch (data[0]) {
                case "course-add":
                    courses.add(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    break;

                case "student-add":
                    students.add(new Student(data[1], data[2], data[3], data[4]));
                    break;

                case "enrollment-add":
                    Course course = findCourseById(courses, data[1]);
                    Student student = findStudentById(students, data[2]);

                    if (course == null) {
                        System.out.println("invalid course|" + data[1]);
                    } 
                    else if (student == null) {
                        System.out.println("invalid student|" + data[2]);
                    } else {
                        enrollments.add(new Enrollment(course, student, data[3], data[4]));
                    }
                    break;

                default:
                    System.out.println("Perintah tidak dikenali!");
            }
        }

        for (Course course : courses) {
            System.out.println(course.toString());
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        sc.close();
    }

    private static Student findStudentById(Set<Student> students, String id) {
        for (Student student : students) {
            if (student.getNim().equals(id)) return student;
        }
        return null;
    }

    private static Course findCourseById(Set<Course> courses, String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) return course;
        }
        return null;
    }
}
