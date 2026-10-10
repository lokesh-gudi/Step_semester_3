public class HostelLaundryQueue {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeWash();
        m1.startWash(neha, new NormalWash());
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

interface WashType {
    int getDuration();
    double getCharge();
    String getName();
}

class QuickWash implements WashType {
    public int getDuration() { return 30; }
    public double getCharge() { return 20; }
    public String getName() { return "Quick"; }
}

class NormalWash implements WashType {
    public int getDuration() { return 45; }
    public double getCharge() { return 30; }
    public String getName() { return "Normal"; }
}

class HeavyWash implements WashType {
    public int getDuration() { return 60; }
    public double getCharge() { return 45; }
    public String getName() { return "Heavy"; }
}

class WashingMachine {
    private String id;
    private WashCycle cycle;

    WashingMachine(String id) {
        this.id = id;
    }

    void startWash(Student student, WashType type) {
        if (cycle != null) {
            System.out.println("Machine " + id + " is currently busy.");
            return;
        }

        cycle = new WashCycle(student, type);

        System.out.printf("%s wash started on %s for %s (%d min).%n",
                type.getName(), id, student.name, type.getDuration());
        System.out.printf("Charge: ₹%.2f%n", type.getCharge());
    }

    void completeWash() {
        if (cycle == null) {
            System.out.println(id + " has no active wash.");
            return;
        }

        System.out.println(id + " cycle completed.");
        cycle = null;
        System.out.println(id + " is now free.");
    }
}

class WashCycle {
    Student student;
    WashType type;

    WashCycle(Student student, WashType type) {
        this.student = student;
        this.type = type;
    }
}