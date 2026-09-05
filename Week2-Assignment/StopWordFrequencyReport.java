import java.util.HashMap;
import java.util.Map;

public class StopWordFrequencyReport {

    void printFilteredWordFrequency(String feedback) {

        String cleanedText =
            feedback.toLowerCase()
                    .replace(".", "")
                    .replace(",", "");

        String[] words =
            cleanedText.split("\\s+");

        String[] stopWords = {
            "the", "was", "and", "a",
            "is", "of", "in"
        };

        HashMap<String, Integer> frequency =
            new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        frequency.entrySet()
                 .stream()
                 .sorted(
                     Map.Entry.<String, Integer>
                     comparingByValue()
                     .reversed()
                 )
                 .forEach(
                     entry -> System.out.println(
                         entry.getKey() +
                         ": " +
                         entry.getValue()
                     )
                 );
    }

    public static void main(String[] args) {

        StopWordFrequencyReport report =
            new StopWordFrequencyReport();

        report.printFilteredWordFrequency(
            "The mentor was great, the session was great and clear."
        );
    }
}