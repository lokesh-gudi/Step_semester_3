public class TypingSpeedAccuracyChecker {

    void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {

                matched++;

            } else if (firstMismatch == -1) {

                firstMismatch = i;
            }
        }

        double accuracy =
            ((double) matched / original.length()) * 100;

        if (firstMismatch == -1) {

            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                matched,
                original.length(),
                accuracy
            );

        } else {

            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | " +
                "First Mismatch at position %d ('%c' vs '%c')%n",
                matched,
                original.length(),
                accuracy,
                firstMismatch + 1,
                original.charAt(firstMismatch),
                typed.charAt(firstMismatch)
            );
        }
    }

    public static void main(String[] args) {

        TypingSpeedAccuracyChecker checker =
            new TypingSpeedAccuracyChecker();

        checker.checkTypingAccuracy(
            "hello world",
            "hello worlt"
        );

        checker.checkTypingAccuracy(
            "coding",
            "coding"
        );
    }
}