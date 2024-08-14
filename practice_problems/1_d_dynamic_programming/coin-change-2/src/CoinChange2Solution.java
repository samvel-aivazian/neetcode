/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(n)
 */
public class CoinChange2Solution {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            int[] nextDP = new int[amount + 1];
            nextDP[0] = 1;

            for (int a = 1; a <= amount; a++) {
                nextDP[a] = dp[a];
                if (a - coins[i] >= 0) {
                    nextDP[a] += nextDP[a - coins[i]];
                }
            }
            dp = nextDP;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(7, new int[]{1, 3, 4}));
    }

}
