/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class PalindromicSubstringsSolution {

    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // Expand around center
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println("Number of palindromic substrings: " + countSubstrings(s1)); // Output: 3

        String s2 = "aaa";
        System.out.println("Number of palindromic substrings: " + countSubstrings(s2)); // Output: 6
    }

}
