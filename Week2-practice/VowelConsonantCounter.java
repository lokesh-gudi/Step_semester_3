public class VowelConsonantCounter {

    void countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = Character.toLowerCase(text.charAt(i));

            if (ch == ' ') {
                continue;
            }

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {

                vowels++;

            } else {
                consonants++;
            }
        }

        System.out.println(
            "Vowels: " + vowels +
            " | Consonants: " + consonants
        );
    }

    public static void main(String[] args) {

        VowelConsonantCounter counter =
            new VowelConsonantCounter();

        counter.countVowelsAndConsonants(
            "Java Programming"
        );
    }
}