public class ProductInventoryCSVParser {

    void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
            "Product: " + fields[0] +
            " | SKU: " + fields[1] +
            " | Qty: " + fields[2]
        );
    }

    public static void main(String[] args) {

        ProductInventoryCSVParser parser =
            new ProductInventoryCSVParser();

        parser.parseInventoryRecord(
            "Wireless Mouse,WM-2201,150"
        );

        parser.parseInventoryRecord(
            "Wireless Mouse,150"
        );
    }
}