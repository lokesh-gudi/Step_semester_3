import java.time.*;
import java.util.*;

public class HotelBookingSystem {
    public static void main(String[] args) {
        Room standard = new StandardRoom("Standard Room 101", 100);
        Room deluxe = new DeluxeRoom("Deluxe Room 201", 150);

        BookingSystem system = new BookingSystem();

        LocalDate start1 = LocalDate.of(2026, 1, 1);
        LocalDate end1 = LocalDate.of(2026, 1, 5);

        system.checkAvailability(standard, start1, end1);

        Reservation r = system.book("Customer A", standard,
                start1, end1);

        system.book("Customer B", standard,
                LocalDate.of(2026, 1, 3),
                LocalDate.of(2026, 1, 7));

        if (r != null) {
            r.cancel(LocalDate.of(2025, 12, 20));
        }

        system.book("Customer C", deluxe,
                LocalDate.of(2026, 2, 10),
                LocalDate.of(2026, 2, 12));
    }
}

abstract class Room {
    String name;
    double rate;

    Room(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    abstract double calculatePrice(long days);
}

class StandardRoom extends Room {
    StandardRoom(String name, double rate) {
        super(name, rate);
    }

    double calculatePrice(long days) {
        return rate * days;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String name, double rate) {
        super(name, rate);
    }

    double calculatePrice(long days) {
        return rate * days;
    }
}

class Reservation {
    String customer;
    Room room;
    LocalDate start, end;
    LocalDate deadline;
    boolean active = true;

    Reservation(String customer, Room room,
                LocalDate start, LocalDate end) {
        this.customer = customer;
        this.room = room;
        this.start = start;
        this.end = end;
        this.deadline = start.minusDays(1);
    }

    boolean overlaps(LocalDate s, LocalDate e) {
        return active && start.isBefore(e) && s.isBefore(end);
    }

    void cancel(LocalDate today) {
        if (!active) {
            System.out.println("Reservation is already inactive.");
        } else if (today.isAfter(deadline)) {
            System.out.println("Cancellation deadline has passed.");
        } else {
            active = false;
            System.out.println("Reservation for " + customer + ", " +
                    room.name + " (" + start + "-" + end +
                    ") cancelled successfully.");
        }
    }
}

class BookingSystem {
    ArrayList<Reservation> reservations = new ArrayList<>();

    boolean available(Room room, LocalDate start, LocalDate end) {
        if (!start.isBefore(end)) {
            return false;
        }

        for (Reservation r : reservations) {
            if (r.room == room && r.overlaps(start, end)) {
                return false;
            }
        }

        return true;
    }

    void checkAvailability(Room room, LocalDate start, LocalDate end) {
        System.out.println(room.name + (available(room, start, end)
                ? " is available from " : " is not available from ")
                + start + " to " + end + ".");
    }

    Reservation book(String customer, Room room,
                     LocalDate start, LocalDate end) {
        if (!available(room, start, end)) {
            System.out.println(room.name + " is not available from "
                    + start + " to " + end + ".");
            return null;
        }

        Reservation r = new Reservation(customer, room, start, end);
        reservations.add(r);

        long days = ChronoUnit.DAYS.between(start, end);

        System.out.println("Reservation confirmed for " + customer +
                ", " + room.name + " (" + start + "-" + end + ").");
        System.out.println("Price: $" + room.calculatePrice(days));

        return r;
    }
}