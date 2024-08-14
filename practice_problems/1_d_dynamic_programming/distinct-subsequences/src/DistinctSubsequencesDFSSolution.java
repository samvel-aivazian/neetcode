/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class DistinctSubsequencesDFSSolution {

    public static int numDistinctDFS(String s, String t) {
        return dfsHelper(s, t, 0, 0);
    }

    private static int dfsHelper(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1; // Successfully matched t
        }
        if (i == s.length()) {
            return 0; // Exhausted s without matching t
        }

        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count += dfsHelper(s, t, i + 1, j + 1);
        }
        count += dfsHelper(s, t, i + 1, j);

        return count;
    }

    public static void main(String[] args) {
        String s1 = "rabbbit";
        String t1 = "rabbit";
        System.out.println("DFS: Number of distinct subsequences: " + numDistinctDFS(s1, t1)); // Output: 3

        String s2 = "babgbag";
        String t2 = "bag";
        System.out.println("DFS: Number of distinct subsequences: " + numDistinctDFS(s2, t2)); // Output: 5
    }

}
