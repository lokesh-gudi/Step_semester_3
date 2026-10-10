import java.util.*;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle sedan = new Sedan("Sedan A", 50);
        Vehicle suv = new SUV("SUV B", 80);

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        RentalSystem system = new RentalSystem();

        system.rent(c1, sedan, 3);
        system.rent(c2, sedan, 2);
        system.returnVehicle(c1, sedan);
        system.rent(c3, suv, 5);
    }
}

abstract class Vehicle {
    String name;
    boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    double rate;

    Sedan(String name, double rate) {
        super(name);
        this.rate = rate;
    }

    double calculateCharge(int days) {
        return rate * days;
    }
}

class SUV extends Vehicle {
    double rate;

    SUV(String name, double rate) {
        super(name);
        this.rate = rate;
    }

    double calculateCharge(int days) {
        return rate * days;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Customer customer;
    Vehicle vehicle;
    int days;

    Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }
}

class RentalSystem {
    ArrayList<Rental> rentals = new ArrayList<>();

    void rent(Customer c, Vehicle v, int days) {
        if (!v.available) {
            System.out.println(v.name + " is currently unavailable.");
            return;
        }

        if (days <= 0) {
            System.out.println("Rental duration must be positive.");
            return;
        }

        v.available = false;
        rentals.add(new Rental(c, v, days));

        System.out.println(v.name + " rented successfully by " + c.name);
        System.out.println("Rental charge: $" + v.calculateCharge(days));
    }

    void returnVehicle(Customer c, Vehicle v) {
        for (Rental r : rentals) {
            if (r.customer == c && r.vehicle == v) {
                rentals.remove(r);
                v.available = true;
                System.out.println(v.name + " returned by " + c.name);
                return;
            }
        }

        System.out.println("No active rental found.");
    }
}