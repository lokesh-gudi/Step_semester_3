public class ThreeTiersOfGymMembership {

    public static void main(String[] args) {

        GymMember standard =
                new GymMember("MEM1", 1000);

        PremiumMember premium =
                new PremiumMember("MEM2", 2000, "Coach Riya");

        EliteMember elite =
                new EliteMember(
                        "MEM3",
                        3000,
                        "Coach Arjun",
                        "L12"
                );

        GroupClassMember group =
                new GroupClassMember(
                        "MEM4",
                        1500,
                        "Zumba"
                );

        System.out.println(standard.displayInfo());
        System.out.println(premium.displayInfo());
        System.out.println(elite.displayInfo());
        System.out.println(group.displayInfo());

        System.out.println(
                GymMember.classifyGeneration(elite)
        );

        System.out.println(
                GymMember.classifyGeneration(group)
        );

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();

        elite.attendSession();
        elite.attendSession();

        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        GymMember[] members = {
                premium,
                elite,
                group
        };

        System.out.println(
                GymMember.getTotalSessionsAttended(members)
        );
    }
}


class GymMember {

    protected String memberId;
    protected int monthlyFee;
    private int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: "
                + sessionsAttended;
    }

    public static String classifyGeneration(GymMember member) {

        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof PremiumMember) {
            return "Second generation";
        }

        return "Standard Member";
    }

    public static int getTotalSessionsAttended(
            GymMember[] members) {

        int total = 0;

        for (GymMember member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }
}


class PremiumMember extends GymMember {

    protected String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {

        return "Premium Member | Trainer: "
                + trainerName
                + " | Sessions: "
                + getSessionsAttended();
    }
}


class EliteMember extends PremiumMember {

    private String lockerNumber;

    public EliteMember(
            String memberId,
            int monthlyFee,
            String trainerName,
            String lockerNumber) {

        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {

        return "Elite Member | Trainer: "
                + trainerName
                + " | Locker: "
                + lockerNumber
                + " | Sessions: "
                + getSessionsAttended();
    }
}


class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(
            String memberId,
            int monthlyFee,
            String className) {

        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {

        return "Group Class Member | Class: "
                + className
                + " | Sessions: "
                + getSessionsAttended();
    }
}