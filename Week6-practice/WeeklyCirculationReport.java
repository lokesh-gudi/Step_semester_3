public class WeeklyCirculationReport {

    public static void main(String[] args) {

        LibraryMember[] members = {

                new LibraryMember(
                        "LB5",
                        3
                ),

                new StudentMember(
                        "STU6",
                        3,
                        "ECE"
                )
        };

        System.out.println(
                LibraryMember.batchPrint(members)
        );
    }
}


class LibraryMember {

    protected String memberId;
    protected int borrowLimit;

    private int booksBorrowed;

    public LibraryMember(
            String memberId,
            int borrowLimit) {

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        booksBorrowed = 0;
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {

        return "General | Books: "
                + booksBorrowed;
    }

    public static String batchPrint(
            LibraryMember[] members) {

        StringBuilder result =
                new StringBuilder();

        for (LibraryMember member : members) {

            result.append(
                    member.displayInfo()
            );

            if (member instanceof StudentMember) {

                StudentMember student =
                        (StudentMember) member;

                result.append(
                        " [Course via downcast: "
                        + student.getCourse()
                        + "]"
                );
            }

            result.append(" | ");
        }

        return result.toString();
    }
}


class StudentMember extends LibraryMember {

    private String course;

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String displayInfo() {

        return "Student | Course: "
                + course
                + " | Books: "
                + getBooksBorrowed();
    }
}