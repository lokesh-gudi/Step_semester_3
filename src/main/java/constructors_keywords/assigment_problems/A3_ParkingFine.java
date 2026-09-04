class ParkingTicket {
    String vehicleNo;
    double ratePerMinute;

    ParkingTicket(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    final double calculateFine(int overstayMinutes) {
        return overstayMinutes * ratePerMinute;
    }

    final void printReceipt(int overstayMinutes) {
        double fine = calculateFine(overstayMinutes);
        System.out.println(vehicleNo + " - Fine: Rs " + fine);
    }
}

public class A3_ParkingFine {
    public static void main(String[] args) {

        String[] vehicleNos = {
            "TN09AB1234",
            "TN22CD5678",
            "TN09EF9012",
            "TN10GH3456"
        };

        double[] rates = {2, 2, 3, 2};

        int[] overstayMinutes = {15, 0, -5, 8};

        for (int i = 0; i < vehicleNos.length; i++) {

            ParkingTicket ticket =
                new ParkingTicket(vehicleNos[i], rates[i]);

            if (overstayMinutes[i] > 0) {
                ticket.printReceipt(overstayMinutes[i]);
            } else {
                System.out.println(
                    vehicleNos[i] + " - No fine, within allotted time"
                );
            }
        }
    }
}