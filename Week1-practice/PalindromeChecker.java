public class PalindromeChecker {

    boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) !=
            text.charAt(text.length() - 1)) {

            return false;
        }

        return isPalindromeRecursive(
            text.substring(1, text.length() - 1)
        );
    }

    boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] =
                original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromeChecker checker =
            new PalindromeChecker();

        String text = "madam";

        boolean iterative =
            checker.isPalindromeIterative(text);

        boolean recursive =
            checker.isPalindromeRecursive(text);

        boolean array =
            checker.isPalindromeArrayReversal(text);

        System.out.println(
            "Iterative: " +
            (iterative ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
            "Recursive: " +
            (recursive ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
            "Array Reversal: " +
            (array ? "Palindrome" : "Not Palindrome")
        );
    }
}