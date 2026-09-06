public class TrafficSignalStreakAnalyzer {

    void findLongestStreak(String signalLog) {

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentColor) {

                currentStreak++;

            } else {

                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {

                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.println(
            "Longest Streak: '" +
            longestColor +
            "' repeated " +
            longestStreak +
            " times"
        );
    }

    public static void main(String[] args) {

        TrafficSignalStreakAnalyzer analyzer =
            new TrafficSignalStreakAnalyzer();

        analyzer.findLongestStreak("RRGGGYRR");

        analyzer.findLongestStreak("RRRRYYGG");
    }
}