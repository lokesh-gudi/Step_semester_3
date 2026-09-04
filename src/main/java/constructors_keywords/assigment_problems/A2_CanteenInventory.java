class Item {
    String itemName;
    int stock;

    Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    void restock(int stock) {
        this.stock = this.stock + stock;
    }
}

public class A2_CanteenInventory {
    public static void main(String[] args) {

        Item[] items = {
            new Item("Samosa", 15),
            new Item("Tea Powder", 40),
            new Item("Bread", 8),
            new Item("Biscuit Packs", 25)
        };

        for (int i = 0; i < items.length; i++) {
            items[i].restock(20);

            System.out.println(
                items[i].itemName + " | Final Stock: " + items[i].stock
            );
        }
    }
}