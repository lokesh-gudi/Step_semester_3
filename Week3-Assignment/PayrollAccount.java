public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {

        if (basicSalary < 0) {
            System.out.println(
                "Warning: Negative basic salary. Starting at Rs 0.0"
            );
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    public void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println(
                "Invalid bonus amount"
            );
            return;
        }

        bonus += amount;

        System.out.println(
            "Bonus credited: Rs " + amount
        );
    }

    public void deductTax(double percent) {

        if (percent < 0 || percent > 100) {
            System.out.println(
                "Invalid tax percentage"
            );
            return;
        }

        basicSalary =
            basicSalary - (basicSalary * percent / 100);

        System.out.println(
            "Tax deducted: " + percent + "%"
        );
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        PayrollAccount account =
            new PayrollAccount(50000);

        account.creditBonus(5000);

        account.deductTax(10);

        System.out.println(
            "Net salary: Rs " +
            account.getNetSalary()
        );
    }
}