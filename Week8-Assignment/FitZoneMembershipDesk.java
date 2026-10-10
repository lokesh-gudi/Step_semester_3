public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership a = asha.buy(new QuarterlyPlan());
        Membership r = ravi.buy(new MonthlyPlan());

        a.checkIn();
        a.freeze();
        a.checkIn();

        r.expire();
        r.freeze();
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }

    Membership buy(MembershipPlan plan) {
        return new Membership(name, plan);
    }
}

interface MembershipPlan {
    double calculateFee();
    String getName();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }

    public String getName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 3000 * 0.90;
    }

    public String getName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() {
        return 12000 * 0.75;
    }

    public String getName() {
        return "Annual";
    }
}

class Membership {
    private String member;
    private MembershipPlan plan;
    private String status = "Active";

    Membership(String member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;

        System.out.println(plan.getName()
                + " membership created for " + member + ".");
        System.out.printf("Fee: ₹%.2f%n", plan.calculateFee());
        System.out.println("Status: " + status + ".");
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member
                    + "'s membership is " + status + ".");
        }
    }

    void freeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
        } else if (status.equals("Frozen")) {
            System.out.println("Membership is already Frozen.");
        } else {
            status = "Frozen";
            System.out.println(member + "'s membership frozen.");
            System.out.println("Status: " + status + ".");
        }
    }

    void unfreeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot unfreeze an Expired membership.");
        } else if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member + "'s membership unfrozen.");
            System.out.println("Status: " + status + ".");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println(member + "'s membership expired.");
        System.out.println("Status: " + status + ".");
    }
}