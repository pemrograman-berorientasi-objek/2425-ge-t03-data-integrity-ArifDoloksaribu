package academic.driver;

import java.util.*;
import academic.model.Student;
import academic.model.Course;
import academic.model.Enrollment;

public class Driver2 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);
        Set<Course> courses = new HashSet<>();
        Set<Student> students = new HashSet<>();
        Set<Enrollment> enrollments = new HashSet<>();
        List<String> errors = new ArrayList<>();

        // Menyimpan ID student dan course yang sudah dinyatakan tidak valid agar tidak dicetak berulang
        Set<String> invalidStudents = new HashSet<>();
        Set<String> invalidCourses = new HashSet<>();

        List<String> inputs = new ArrayList<>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;
            inputs.add(input);
        }

        for (String input : inputs) {
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

                    if (student == null && !invalidStudents.contains(data[2])) {
                        errors.add("invalid student|" + data[2]);
                        invalidStudents.add(data[2]); // Tambahkan ke daftar student invalid yang sudah dilaporkan
                    }
                    if (course == null && !invalidCourses.contains(data[1])) {
                        errors.add("invalid course|" + data[1]);
                        invalidCourses.add(data[1]); // Tambahkan ke daftar course invalid yang sudah dilaporkan
                    }
                    if (student != null && course != null) {
                        enrollments.add(new Enrollment(course, student, data[3], data[4]));
                    }
                    break;

                default:
                    break;
            }
        }

        for (String error : errors) {
            System.out.println(error);
        }
        for (Course course : courses) {
            System.out.println(course);
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
