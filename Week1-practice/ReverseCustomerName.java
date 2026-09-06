public class ReverseCustomerName {

    String reverseCustomerName(String customerName) {

        char[] characters =
            customerName.toCharArray();

        StringBuilder reversed =
            new StringBuilder();

        for (int i = characters.length - 1;
             i >= 0;
             i--) {

            reversed.append(characters[i]);
        }

        return reversed.toString();
    }

    public static void main(String[] args) {

        ReverseCustomerName reverser =
            new ReverseCustomerName();

        String originalName = "Sunil";

        String reversedName =
            reverser.reverseCustomerName(originalName);

        System.out.println(
            "Original Name: " + originalName
        );

        System.out.println(
            "Reversed Name: " + reversedName
        );
    }
}