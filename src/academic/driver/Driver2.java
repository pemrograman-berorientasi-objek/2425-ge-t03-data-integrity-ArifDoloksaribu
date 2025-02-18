package academic.driver;

import java.util.*;
import academic.model.Student;
import academic.model.Course;
import academic.model.Enrollment;

public class Driver2 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Course> courses = new LinkedList<>();
        LinkedList<Student> students = new LinkedList<>();
        Set<Enrollment> enrollments = new LinkedHashSet<>();

        Set<String> invalidStudents = new LinkedHashSet<>();
        Set<String> invalidCourses = new LinkedHashSet<>();

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
                    courses.addFirst(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    break;

                case "student-add":
                    students.addFirst(new Student(data[1], data[2], data[3], data[4]));
                    break;

                case "enrollment-add":
                    Course course = findCourseById(courses, data[1]);
                    Student student = findStudentById(students, data[2]);

                    if (course == null) {
                        invalidCourses.add("invalid course|" + data[1]);
                    } else if (student == null) { 
                        // Student hanya dianggap invalid jika course ada
                        invalidStudents.add("invalid student|" + data[2]);
                    } else {
                        enrollments.add(new Enrollment(course, student, data[3], data[4]));
                    }
                    break;

                default:
                    System.out.println("Perintah tidak dikenali: " + input);
            }
        }

        // Cetak error dengan urutan sesuai input
        for (String error : invalidStudents) {
            System.out.println(error);
        }
        for (String error : invalidCourses) {
            System.out.println(error);
        }

        // Cetak courses dalam urutan terbaru ke terlama
        for (Course course : courses) {
            System.out.println(course);
        }

        // Cetak students dalam urutan terbaru ke terlama
        for (Student student : students) {
            System.out.println(student);
        }

        // Cetak enrollments sesuai urutan input
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        sc.close();
    }

    private static Student findStudentById(LinkedList<Student> students, String id) {
        for (Student student : students) {
            if (student.getNim().equals(id)) return student;
        }
        return null;
    }

    private static Course findCourseById(LinkedList<Course> courses, String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) return course;
        }
        return null;
    }
}
