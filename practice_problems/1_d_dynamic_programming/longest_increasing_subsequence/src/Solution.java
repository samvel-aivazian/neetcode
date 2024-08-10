import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        final int lisLength = lengthOfLIS(new int[]{1, 3, 4, 1});
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
    }

}
