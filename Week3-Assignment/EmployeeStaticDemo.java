public class EmployeeStaticDemo {

    String empName;
    double salary;

    static String companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    EmployeeStaticDemo(String empName, double salary) {

        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println(
            "Employees on record: " + employeeCount
        );
    }

    public static void main(String[] args) {

        EmployeeStaticDemo employee1 =
            new EmployeeStaticDemo("Divya", 65000);

        EmployeeStaticDemo employee2 =
            new EmployeeStaticDemo("Arjun", 45000);

        EmployeeStaticDemo employee3 =
            new EmployeeStaticDemo("Priya", 55000);

        EmployeeStaticDemo.printCompanyInfo();
    }
}