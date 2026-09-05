public class CineScreen {

    private final int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {

        if (seatsTotal <= 0 || seatsTotal > 300) {
            throw new IllegalArgumentException(
                "seatsTotal must be between 1 and 300"
            );
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {

        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {

        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {

        try {
            CineScreen invalid = new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        CineScreen c = new CineScreen(2);

        c.bookSeat();
        c.bookSeat();
        c.bookSeat();

        System.out.println(c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking();

        System.out.println(c.getSeatsAvailable());
    }
}