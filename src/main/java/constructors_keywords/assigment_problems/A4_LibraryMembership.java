class MembershipCard {
    static String libraryName;
    static String validUntil;

    String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";

        System.out.println("Library info loaded");
    }

    MembershipCard(String studentName) {
        this.studentName = studentName;
    }
}

public class A4_LibraryMembership {
    public static void main(String[] args) {

        String[] names = {
            "Ananya",
            "Rohan",
            "Priya",
            "Arjun",
            "Sneha"
        };

        for (int i = 0; i < names.length; i++) {

            MembershipCard card =
                new MembershipCard(names[i]);

            System.out.println(
                "Membership card issued: " + card.studentName
            );
        }
    }
}