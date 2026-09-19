public class ThreeBranchesOfMembership {

    public static void main(String[] args) {

        LibraryMember general =
                new LibraryMember("STU1", 3);

        StudentMember student =
                new StudentMember(
                        "STU2",
                        3,
                        "CSE"
                );

        HonorsStudentMember honors =
                new HonorsStudentMember(
                        "STU3",
                        3,
                        "ECE",
                        2
                );

        FacultyMember faculty =
                new FacultyMember(
                        "STU4",
                        5,
                        "Physics"
                );

        System.out.println(general.displayInfo());
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());

        System.out.println(
                LibraryMember.classifyGeneration(honors)
        );

        System.out.println(
                LibraryMember.classifyGeneration(faculty)
        );

        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        LibraryMember[] members = {
                student,
                honors,
                faculty
        };

        System.out.println(
                LibraryMember.getTotalBooksBorrowed(members)
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
        this.booksBorrowed = 0;
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

        return "General Member | Books Borrowed: "
                + booksBorrowed;
    }

    public static String classifyGeneration(
            LibraryMember member) {

        if (member instanceof HonorsStudentMember) {

            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {

            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof StudentMember) {

            return "Second generation";
        }

        return "General Member";
    }

    public static int getTotalBooksBorrowed(
            LibraryMember[] members) {

        int total = 0;

        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }
}


class StudentMember extends LibraryMember {

    protected String course;

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {

        return "Student Member | Course: "
                + course
                + " | Books Borrowed: "
                + getBooksBorrowed();
    }
}


class HonorsStudentMember extends StudentMember {

    private int bonusLimit;

    public HonorsStudentMember(
            String memberId,
            int borrowLimit,
            String course,
            int bonusLimit) {

        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {

        return "Honors Student Member | Course: "
                + course
                + " | Bonus Limit: "
                + bonusLimit
                + " | Books Borrowed: "
                + getBooksBorrowed();
    }
}


class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(
            String memberId,
            int borrowLimit,
            String department) {

        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {

        return "Faculty Member | Department: "
                + department
                + " | Books Borrowed: "
                + getBooksBorrowed();
    }
}