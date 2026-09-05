class SrmStudent {
    static String collegeName;
    static String academicYear;

    String name;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-27";
        System.out.println("College info loaded");
    }

    SrmStudent(String name) {
        this.name = name;
    }

    void printRecord() {
        System.out.println("Student record created: " + name);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            student.printRecord();
        }
    }
}