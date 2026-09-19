public class MembershipCirculationAudit {

    public static void main(String[] args) {

        LibraryMember m1 =
                new LibraryMember(3);

        System.out.println(
                m1.getMemberNumber()
        );

        System.out.println(
                LibraryMember.getMembersEnrolled()
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("R12A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("R1A")
        );

        System.out.println(
                LibraryMember.isValidRenewalCode("X12A")
        );

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(
                m1.getBooksBorrowed()
        );

        LibraryMember[] members = {

                new FacultyMember(
                        5,
                        "Physics"
                ),

                null,

                new LibraryMember(3)
        };

        System.out.println(
                LibraryMember.processNightlyAudit(
                        members
                )
        );
    }
}


class LibraryMember {

    private static int memberCounter = 100;
    private static int membersEnrolled = 0;

    private final String memberNumber;

    private int borrowLimit;
    private int booksBorrowed;

    private String lastGenre;

    public LibraryMember(int borrowLimit) {

        this.borrowLimit = borrowLimit;

        memberCounter++;

        memberNumber =
                "LIB-" + memberCounter;

        membersEnrolled++;
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {

        lastGenre = genre;

        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static boolean isValidRenewalCode(
            String code) {

        if (code == null ||
                code.length() != 4) {

            return false;
        }

        if (code.charAt(0) != 'R') {
            return false;
        }

        if (!Character.isDigit(
                code.charAt(1))) {

            return false;
        }

        if (!Character.isDigit(
                code.charAt(2))) {

            return false;
        }

        if (!Character.isUpperCase(
                code.charAt(3))) {

            return false;
        }

        return true;
    }

    public static String processNightlyAudit(
            LibraryMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMember member : members) {

            if (member == null) {

                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }

        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + faculty
                + " faculty | "
                + regular
                + " regular";
    }
}


class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(
            int borrowLimit,
            String department) {

        super(borrowLimit);

        this.department = department;
    }
}