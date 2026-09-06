public class BankTransactionReferenceValidator {

    String normalizeReference(String raw) {

        raw = raw.trim();

        String bankCode =
            raw.substring(0, 3).toUpperCase();

        String remaining =
            raw.substring(3);

        return bankCode + remaining;
    }

    String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode =
            reference.substring(0, 3);

        String date =
            reference.substring(3, 9);

        String sequence =
            reference.substring(9, 14);

        String day =
            date.substring(0, 2);

        String month =
            date.substring(2, 4);

        String year =
            date.substring(4, 6);

        StringBuilder result =
            new StringBuilder();

        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(day)
              .append("/")
              .append(month)
              .append("/")
              .append(year)
              .append(" | SEQ: ")
              .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        BankTransactionReferenceValidator validator =
            new BankTransactionReferenceValidator();

        String rawReference =
            " hdf03022600042 ";

        String normalized =
            validator.normalizeReference(rawReference);

        System.out.println(
            validator.validateAndFormat(normalized)
        );

        String invalidReference =
            "12F03022600042";

        String normalizedInvalid =
            validator.normalizeReference(invalidReference);

        System.out.println(
            validator.validateAndFormat(normalizedInvalid)
        );
    }
}