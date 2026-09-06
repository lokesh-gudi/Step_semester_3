public class MaskedPhoneNumberFormatter {

    String maskPhoneNumber(String phone) {

        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder result =
            new StringBuilder("XXXXXX");

        result.append("-");

        result.append(
            phone.substring(6)
        );

        return result.toString();
    }

    public static void main(String[] args) {

        MaskedPhoneNumberFormatter formatter =
            new MaskedPhoneNumberFormatter();

        System.out.println(
            formatter.maskPhoneNumber("9876543210")
        );

        System.out.println(
            formatter.maskPhoneNumber("98765")
        );
    }
}