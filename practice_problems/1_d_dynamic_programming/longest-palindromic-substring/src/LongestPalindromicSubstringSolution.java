public class LongestPalindromicSubstringSolution {

    public static String getLongestPalindrome(String s) {
        int n = s.length();
        String longestPalindrome = "";
        int resultLength = 0;

        // Expand around center
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultLength) {
                    longestPalindrome = s.substring(left, right + 1);
                    resultLength = right - left + 1;
                }

                left--;
                right++;
            }
        }

        return longestPalindrome;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println("Longest palindrome: " + getLongestPalindrome(s1)); // Output: 3

        String s2 = "aaa";
        System.out.println("Longest palindrome: " + getLongestPalindrome(s2)); // Output: 6
    }

}
