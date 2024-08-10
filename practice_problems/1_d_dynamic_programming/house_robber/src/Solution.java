public class Solution {

    public static void main(String[] args) {
        final int maximumToRob = rob(new int[]{1, 3, 4, 1});
        System.out.println("Maximum to Rob: " + maximumToRob);
    }

    public static int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

}
