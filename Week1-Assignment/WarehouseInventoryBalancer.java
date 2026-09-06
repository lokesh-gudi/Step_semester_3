public class WarehouseInventoryBalancer {

    void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }

        String status;

        if (totalA == totalB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {

            if (sectionA[i] > highestQuantity) {

                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {

            if (sectionB[i] > highestQuantity) {

                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println(
            "Section A Total: " + totalA +
            " | Section B Total: " + totalB +
            " | Status: " + status
        );

        System.out.println(
            "Highest Quantity: " +
            highestQuantity +
            " (" +
            highestSection +
            ", Item " +
            (highestIndex + 1) +
            ")"
        );
    }

    public static void main(String[] args) {

        WarehouseInventoryBalancer balancer =
            new WarehouseInventoryBalancer();

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        balancer.analyzeInventory(sectionA, sectionB);
    }
}