public class Solution {

    public static void main(String[] args) {
        final int totalNumberOfApproaches = climbStairs(10);
        System.out.println("Total number of approaches: " + totalNumberOfApproaches);
    }

    private static int climbStairs(int n) {
        int waysToReachPreviousStep = 1; // Represents ways to reach (i-2)th step
        int waysToReachCurrentStep = 1;  // Represents ways to reach (i-1)th step

        for (int i = 0; i < n - 1; i++) {
            int waysToReachNextStep = waysToReachPreviousStep + waysToReachCurrentStep;
            waysToReachPreviousStep = waysToReachCurrentStep;
            waysToReachCurrentStep = waysToReachNextStep;
        }

        return waysToReachCurrentStep;
    }

}
