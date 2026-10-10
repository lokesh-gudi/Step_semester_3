import java.util.*;

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        Show show = new Show("7 PM");

        Booking asha = show.book("Asha",
                new RegularSeat("A1"),
                new RegularSeat("A2"),
                new PremiumSeat("F5"));

        show.book("Ravi", new RegularSeat("A2"));
        show.book("Ravi", new ReclinerSeat("R1"));

        if (asha != null) asha.cancel();

        show.book("Neha", new RegularSeat("A2"));
    }
}

abstract class Seat {
    String id;

    Seat(String id) {
        this.id = id;
    }

    abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    PremiumSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String id) {
        super(id);
    }

    double getPrice() {
        return 400;
    }
}

class Show {
    String time;
    Map<String, Seat> booked = new HashMap<>();

    Show(String time) {
        this.time = time;
    }

    Booking book(String customer, Seat... seats) {
        if (seats.length == 0 || seats.length > 6) {
            System.out.println("A booking must contain 1 to 6 seats.");
            return null;
        }

        Set<String> requested = new HashSet<>();

        for (Seat seat : seats) {
            if (booked.containsKey(seat.id) || !requested.add(seat.id)) {
                System.out.println("Seat " + seat.id
                        + " is already booked for this show.");
                return null;
            }
        }

        Booking booking = new Booking(customer, this, seats);

        for (Seat seat : seats) {
            booked.put(seat.id, seat);
        }

        System.out.print("Booking confirmed for " + customer + ": ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i].id
                    + (i < seats.length - 1 ? ", " : ""));
        }

        System.out.printf(". Total: ₹%.2f%n", booking.total());
        return booking;
    }
}

class Booking {
    String customer;
    Show show;
    List<Seat> seats;
    boolean active = true;

    Booking(String customer, Show show, Seat... seats) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>(Arrays.asList(seats));
    }

    double total() {
        double sum = 0;

        for (Seat seat : seats) {
            sum += seat.getPrice();
        }

        return sum;
    }

    void cancel() {
        if (!active) {
            System.out.println("Booking is already cancelled.");
            return;
        }

        active = false;

        for (Seat seat : seats) {
            show.booked.remove(seat.id);
        }

        System.out.println(customer + "'s booking cancelled.");
        System.out.print("Seats ");

        for (int i = 0; i < seats.size(); i++) {
            System.out.print(seats.get(i).id
                    + (i < seats.size() - 1 ? ", " : ""));
        }

        System.out.println(" released.");
    }
}