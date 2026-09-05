public class WordReversalEncoder {

    String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversed =
                new StringBuilder(words[i]);

            reversed.reverse();

            result.append(reversed);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        WordReversalEncoder encoder =
            new WordReversalEncoder();

        String result =
            encoder.reverseEachWord("hello club");

        System.out.println(result);
    }
}