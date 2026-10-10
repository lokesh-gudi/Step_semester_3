import java.util.*;

public class PairWithTargetSumArray {
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
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 4, 6};

        System.out.println(hasPairWithSum(a, 9));
        System.out.println(hasPairWithSum(b, 20));
    }
}