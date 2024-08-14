/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 */
public class DistinctSubsequencesDPSolution {

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // An empty t is a subsequence of any prefix of s
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "rabbbit";
        String t1 = "rabbit";
        System.out.println("DP: Number of distinct subsequences: " + numDistinct(s1, t1)); // Output: 3

        String s2 = "babgbag";
        String t2 = "bag";
        System.out.println("DP: Number of distinct subsequences: " + numDistinct(s2, t2)); // Output: 5
    }

}
