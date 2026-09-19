public interface Printable {

    String printLabel();

    static void printAll(Printable[] items) {

        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }
}

class PackageBox implements Printable {

    private String trackingId;

    public PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingId;
    }
}

class Invoice implements Printable {

    private String invoiceNumber;

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}