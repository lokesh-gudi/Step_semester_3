import java.util.*;

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Customer x = new Customer("Customer X");
        Order orderX = new Order("Order X", x);

        orderX.addProduct(new Product("Product A", 100), 2);
        orderX.addProduct(new Product("Product B", 50), 1);
        orderX.pay(new CreditCardPayment(true));

        Customer y = new Customer("Customer Y");
        Order orderY = new Order("Order Y", y);
        orderY.pay(new CreditCardPayment(true));

        Customer z = new Customer("Customer Z");
        Order orderZ = new Order("Order Z", z);
        orderZ.addProduct(new Product("Product C", 200), 1);
        orderZ.pay(new PayPalPayment(false));
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    Product product;
    int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double total() {
        return product.price * quantity;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount);
    String getName();
}

class CreditCardPayment implements PaymentMethod {
    boolean success;

    CreditCardPayment(boolean success) {
        this.success = success;
    }

    public boolean processPayment(double amount) {
        return success;
    }

    public String getName() {
        return "Credit Card";
    }
}

class PayPalPayment implements PaymentMethod {
    boolean success;

    PayPalPayment(boolean success) {
        this.success = success;
    }

    public boolean processPayment(double amount) {
        return success;
    }

    public String getName() {
        return "PayPal";
    }
}

class BankTransferPayment implements PaymentMethod {
    boolean success;

    BankTransferPayment(boolean success) {
        this.success = success;
    }

    public boolean processPayment(double amount) {
        return success;
    }

    public String getName() {
        return "Bank Transfer";
    }
}

class Order {
    String name;
    Customer customer;
    ArrayList<OrderItem> items = new ArrayList<>();
    String status = "Pending";

    Order(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
        System.out.println("Order created for " + customer.name + ".");
    }

    void addProduct(Product product, int quantity) {
        if (quantity > 0) {
            items.add(new OrderItem(product, quantity));
        }
    }

    double total() {
        double sum = 0;

        for (OrderItem item : items) {
            sum += item.total();
        }

        return sum;
    }

    void pay(PaymentMethod method) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println("Payment initiated via " + method.getName()
                + " for " + name + ".");

        if (method.processPayment(total())) {
            status = "Paid";
            System.out.println("Payment for " + name + " successful.");
        } else {
            System.out.println("Payment for " + name + " failed.");
        }

        System.out.println("Order status: " + status + ".");
    }
}