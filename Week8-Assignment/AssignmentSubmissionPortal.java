import java.time.*;
import java.time.temporal.ChronoUnit;

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Student2 asha = new Student2("Asha");
        Student2 ravi = new Student2("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50, LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay", 50, LocalDate.of(2026, 3, 12));

        Submission s1 = asha.submit(coding, LocalDate.of(2026, 3, 10));
        Submission s2 = ravi.submit(written, LocalDate.of(2026, 3, 14));

        if (s1 != null) s1.grade(45);
        if (s2 != null) s2.grade(40);

        if (s1 != null) s1.resubmit();
    }
}

class Student2 {
    String name;

    Student2(String name) {
        this.name = name;
    }

    Submission submit(Assignment a, LocalDate date) {
        return new Submission(name, a, date);
    }
}

abstract class Assignment {
    String title;
    int maxMarks;
    LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double penaltyPerDay();

    double calculateMarks(double marks, long lateDays) {
        double penalty = Math.min(1.0, penaltyPerDay() * lateDays);
        return Math.max(0, marks * (1 - penalty));
    }
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, int marks, LocalDate dueDate) {
        super(title, marks, dueDate);
    }

    double penaltyPerDay() {
        return 0.10;
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, int marks, LocalDate dueDate) {
        super(title, marks, dueDate);
    }

    double penaltyPerDay() {
        return 0.20;
    }
}

class Submission {
    private String student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private String status = "Submitted";

    Submission(String student, Assignment assignment, LocalDate date) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = date;

        long days = Math.max(0,
                ChronoUnit.DAYS.between(assignment.dueDate, date));

        System.out.printf("%s's submission for '%s' received (%s). Status: Submitted.%n",
                student, assignment.title,
                days == 0 ? "on time" : days + " days late");
    }

    void grade(double marks) {
        if (!status.equals("Submitted")) {
            System.out.println("Submission has already been graded.");
            return;
        }

        if (marks < 0 || marks > assignment.maxMarks) {
            System.out.println("Invalid marks.");
            return;
        }

        long days = Math.max(0,
                ChronoUnit.DAYS.between(assignment.dueDate, submissionDate));

        double finalMarks = assignment.calculateMarks(marks, days);
        status = "Graded";

        if (days > 0) {
            System.out.printf("%s graded: %.0f/%d after %.0f%% late penalty.%n",
                    student, finalMarks, assignment.maxMarks,
                    Math.min(100, assignment.penaltyPerDay() * days * 100));
        } else {
            System.out.printf("%s graded: %.0f/%d.%n",
                    student, finalMarks, assignment.maxMarks);
        }

        System.out.println("Status: " + status + ".");
    }

    void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" + assignment.title
                    + "' has already been graded.");
        } else {
            System.out.println("Resubmission allowed.");
        }
    }
}