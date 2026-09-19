public class MembershipSettlement {

    public static void main(String[] args) {

        GymMember m1 =
                new GymMember(1000);

        System.out.println(
                m1.getMembershipNumber()
        );

        System.out.println(
                GymMember.getMembersEnrolled()
        );

        System.out.println(
                GymMember.isValidReferralCode("G45B")
        );

        System.out.println(
                GymMember.isValidReferralCode("G4B")
        );

        System.out.println(
                GymMember.isValidReferralCode("X45B")
        );

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(
                m1.getFeesPaid()
        );

        GymMember[] members = {

            new GroupClassMember(
                    1500,
                    "Zumba"
            ),

            null,

            new GymMember(1000)
        };

        System.out.println(
                GymMember.processWeeklyCheckIn(members)
        );
    }
}


class GymMember {

    private static int memberCounter = 2000;
    private static int membersEnrolled = 0;

    private final String membershipNumber;

    private int monthlyFee;
    private int feesPaid;

    private String lastPaymentMode;

    public GymMember(int monthlyFee) {

        this.monthlyFee = monthlyFee;

        memberCounter++;

        membershipNumber =
                "GYM-" + memberCounter;

        membersEnrolled++;
    }

    public void payFee(int amount) {

        feesPaid += amount;
    }

    public void payFee(
            int amount,
            String mode) {

        lastPaymentMode = mode;

        payFee(amount);
    }

    public int getFeesPaid() {

        return feesPaid;
    }

    public String getMembershipNumber() {

        return membershipNumber;
    }

    public static int getMembersEnrolled() {

        return membersEnrolled;
    }

    public static boolean isValidReferralCode(
            String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {

                nullSkipped++;

                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + group
                + " group | "
                + individual
                + " individual";
    }
}


class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(
            int monthlyFee,
            String className) {

        super(monthlyFee);

        this.className = className;
    }
}