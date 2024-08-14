public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it can't be partitioned into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        // Target sum for each subset
        int target = totalSum / 2;

        // DP array to store whether a sum is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Zero sum is always possible (empty subset)

        // Iterate through the numbers in the array
        for (int num : nums) {
            // Update the DP array from the back to avoid overwriting values
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // Return whether the target sum is possible
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(canPartition(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(canPartition(nums2)); // Output: false
    }

}
