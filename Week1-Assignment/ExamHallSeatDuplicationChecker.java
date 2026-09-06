public class ExamHallSeatDuplicationChecker {

    void checkDuplicateSeats(int[] seatNumbers) {

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {

                    System.out.println(
                        "Duplicate Seat Number Found: "
                        + seatNumbers[i]
                    );

                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        ExamHallSeatDuplicationChecker checker =
            new ExamHallSeatDuplicationChecker();

        int[] seats = {101, 102, 103, 102, 105};

        checker.checkDuplicateSeats(seats);
    }
}