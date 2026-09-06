public class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    private boolean membershipIdSet;

    public LibraryMember() {
        membershipIdSet = false;
    }

    public String getMembershipId() {

        return membershipId;
    }

    public void setMembershipId(String id) {

        if (!membershipIdSet) {

            membershipId = id;
            membershipIdSet = true;
        }
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean isPremiumMember() {

        return premiumMember;
    }

    public void setPremiumMember(
            boolean premium) {

        this.premiumMember = premium;
    }

    public void setSecurityAnswer(
            String answer) {

        securityAnswer = oneWayTransform(answer);
    }

    private String oneWayTransform(
            String answer) {

        int hash = 7;

        for (int i = 0; i < answer.length(); i++) {

            hash = hash * 31 +
                   answer.charAt(i);
        }

        return Integer.toHexString(hash);
    }

    public static void main(String[] args) {

        LibraryMember m =
                new LibraryMember();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(
            m.getMembershipId()
        );

        m.setMembershipId("FAKE-0000");

        System.out.println(
            m.getMembershipId()
        );

        System.out.println(
            m.isPremiumMember()
        );

        m.setSecurityAnswer(
            "BlueMountain"
        );
    }
}