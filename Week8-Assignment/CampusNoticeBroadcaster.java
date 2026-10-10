import java.util.*;

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student3 asha = new Student3("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student3 ravi = new Student3("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        board.addStudent(asha);
        board.addStudent(ravi);

        board.post(new Notice("Lab Closed Tomorrow", "CSE"));
        board.post(new Notice("Fee Deadline Extended", "CSE", "ECE"));
        board.post(new Notice("Sports Day"));
    }
}

interface NotificationChannel {
    void send(String student, String title);
}

class EmailChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("[Email → " + student + "] " + title);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("[SMS → " + student + "] " + title);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("[App → " + student + "] " + title);
    }
}

class Student3 {
    String name, department;
    List<NotificationChannel> channels = new ArrayList<>();

    Student3(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    Set<String> departments = new LinkedHashSet<>();

    Notice(String title, String... departments) {
        this.title = title;
        this.departments.addAll(Arrays.asList(departments));
    }
}

class NoticeBoard {
    List<Student3> students = new ArrayList<>();

    void addStudent(Student3 student) {
        students.add(student);
    }

    void post(Notice notice) {
        if (notice.title == null || notice.title.trim().isEmpty()) {
            System.out.println("Cannot post notice: Title is required.");
            return;
        }

        if (notice.departments.isEmpty()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.title + "' posted to "
                + String.join(", ", notice.departments) + ".");

        for (Student3 student : students) {
            if (notice.departments.contains(student.department)) {
                for (NotificationChannel channel : student.channels) {
                    channel.send(student.name, notice.title);
                }
            }
        }
    }
}