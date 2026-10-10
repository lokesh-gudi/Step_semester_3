public class MaximizeContainerArea {
    static int maxContainerArea(int[] heights) {
        int left = 0, right = heights.length - 1, max = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right])
                       * (right - left);

            max = Math.max(max, area);

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));
    }
}