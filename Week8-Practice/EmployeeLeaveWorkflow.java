public class EmployeeLeaveWorkflow {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest r1 = john.applyLeave("Jan 1-5", 5);
        r1.review("Alice", true);
        r1.changeStatus("Pending");

        LeaveRequest r2 = jane.applyLeave("Feb 10-11", 2);
        r2.review("Bob", false);
    }
}

abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract int maxLeaveDays();

    LeaveRequest applyLeave(String dates, int days) {
        if (days <= 0 || days > maxLeaveDays()) {
            System.out.println("Leave request rejected: Invalid duration.");
            return null;
        }

        LeaveRequest request = new LeaveRequest(name, dates);
        System.out.println("Leave request submitted for " + name +
                " (" + dates + "). Status: Pending.");
        return request;
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }

    int maxLeaveDays() {
        return 30;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }

    int maxLeaveDays() {
        return 10;
    }
}

class Contractor extends Employee {
    Contractor(String name) {
        super(name);
    }

    int maxLeaveDays() {
        return 5;
    }
}

class LeaveRequest {
    private String employee, dates;
    private String status = "Pending";

    LeaveRequest(String employee, String dates) {
        this.employee = employee;
        this.dates = dates;
    }

    void review(String manager, boolean approved) {
        if (!status.equals("Pending")) {
            System.out.println("Request has already been reviewed.");
            return;
        }

        status = approved ? "Approved" : "Rejected";

        System.out.println(employee + "'s leave request (" + dates + ") "
                + status.toLowerCase() + " by " + manager + ".");
        System.out.println("Status: " + status);
    }

    void changeStatus(String newStatus) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to " + newStatus + ".");
        } else {
            status = newStatus;
        }
    }
}