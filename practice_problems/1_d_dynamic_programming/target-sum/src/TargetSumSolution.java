import java.util.HashMap;
import java.util.Map;

public class TargetSumSolution {

    public static int findTargetSumWays(int[] nums, int target) {
        // Memoization map
        Map<String, Integer> memo = new HashMap<>();
        return calculateWays(nums, 0, 0, target, memo);
    }

    private static int calculateWays(int[] nums, int index, int currentSum, int target, Map<String, Integer> memo) {
        // Base case: if we have processed all numbers
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // Construct a unique key for memoization
        String key = index + "," + currentSum;

        // If the result for this subproblem is already computed, return it
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursive call: include the current number with a plus or minus sign
        int add = calculateWays(nums, index + 1, currentSum + nums[index], target, memo);
        int subtract = calculateWays(nums, index + 1, currentSum - nums[index], target, memo);

        // Store the result in memo and return the total number of ways
        memo.put(key, add + subtract);
        return memo.get(key);
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 2};
        int target1 = 2;
        System.out.println("Number of ways: " + findTargetSumWays(nums1, target1)); // Output: 3

        int[] nums2 = {1, 1, 1, 1, 1};
        int target2 = 3;
        System.out.println("Number of ways: " + findTargetSumWays(nums2, target2)); // Output: 5
    }

}
