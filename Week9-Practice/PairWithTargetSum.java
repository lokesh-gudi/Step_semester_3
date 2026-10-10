import java.util.*;

public class PairWithTargetSum {
    static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(target - n))
                return true;

            set.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(
            new int[]{2, 7, 11, 15}, 9));

        System.out.println(hasPairWithSum(
            new int[]{3, 4, 6}, 20));
    }
}