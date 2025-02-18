package academic.model;
import academic.model.Student;

/**
* @author 12S23004 Pooppy Sibuea
 * @author 12S23026 Arif M. Doloksaribu
 */
public class Student {

    // class definition
    private String nim;
    private String name;
    private String tahun;
    private String prodi;

    public Student(String nim, String name, String tahun, String prodi) {
        this.nim = nim;
        this.name = name;
        this.tahun = tahun;
        this.prodi = prodi;
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public String getTahun() {
        return tahun;
    }

    public String getProdi() {
        return prodi;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + tahun + "|" + prodi;
    }
}