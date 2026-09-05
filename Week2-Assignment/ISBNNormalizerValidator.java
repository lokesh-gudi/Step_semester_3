public class ISBNNormalizerValidator {

    String normalizeCode(String raw) {

        raw = raw.trim();

        String publisher =
            raw.substring(0, 3).toUpperCase();

        String remaining =
            raw.substring(3);

        return publisher + remaining;
    }

    String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisher =
            code.substring(0, 3);

        String year =
            code.substring(3, 7);

        String catalog =
            code.substring(7, 13);

        StringBuilder result =
            new StringBuilder();

        result.append("[")
              .append(publisher)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        ISBNNormalizerValidator validator =
            new ISBNNormalizerValidator();

        String rawCode = " pen2026004251 ";

        String normalized =
            validator.normalizeCode(rawCode);

        System.out.println(
            validator.validateAndFormat(normalized)
        );

        String invalidCode = "12N2026004251";

        String normalizedInvalid =
            validator.normalizeCode(invalidCode);

        System.out.println(
            validator.validateAndFormat(normalizedInvalid)
        );
    }
}