public class MonthlyAttendanceAnnouncer {

    public static void main(String[] args) {

        GymMember[] members = {

            new GymMember("MEM6", 1000),

            new PremiumMember(
                    "MEM7",
                    2000,
                    "Coach Riya"
            )
        };

        System.out.println(
                GymMember.batchPrint(members)
        );
    }
}


class GymMember {

    protected String memberId;
    protected int monthlyFee;

    private int sessionsAttended;

    public GymMember(
            String memberId,
            int monthlyFee) {

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {

        return "Standard | Sessions: "
                + sessionsAttended;
    }

    public static String batchPrint(
            GymMember[] members) {

        StringBuilder result =
                new StringBuilder();

        for (GymMember member : members) {

            result.append(
                    member.displayInfo()
            );

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                result.append(
                        " [Trainer via downcast: "
                        + premium.getTrainerName()
                        + "]"
                );
            }

            result.append(" | ");
        }

        return result.toString();
    }
}


class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {

        return "Premium | Trainer: "
                + trainerName
                + " | Sessions: "
                + getSessionsAttended();
    }
}