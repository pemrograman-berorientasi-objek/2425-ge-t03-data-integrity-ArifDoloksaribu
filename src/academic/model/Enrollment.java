package academic.model;
/**
 * @author 12S23004 - Poppy Sibuea
 * @author 12S23026 - Arif Doloksaribu
 */
public class Enrollment {

    // class definition
    private Student student;
    private Course course;
    private String Tahun;
    private String Semester;
    private String Grade = "None";

    public Enrollment(Course course, Student student,  String Tahun, String Semester) {
        this.course = course;
        this.student = student;
        this.Tahun = Tahun;
        this.Semester = Semester;
    }

    public String getStudentId() {
        return student.getNim();
    }
    
    public String getCourseId() {
        return course.getId();
    }

    public void setTahun(String Tahun) {
        this.Tahun = Tahun;
    }
    
    public String getTahun() {
        return Tahun;
    }

    public String getSemester() {
        return Semester;
    }

    public String getGrade() {
        return Grade;
    }

    @Override
    public String toString() {
        return course.getId() + "|" + student.getNim() + "|" + Tahun + "|" + Semester + "|" + Grade;
    }
}