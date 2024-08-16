import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MinimumCostForTicketsSolution {

    public static int minCostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {
            if (!daySet.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            int cost1Day = dp[Math.max(0, i - 1)] + costs[0];
            int cost7Day = dp[Math.max(0, i - 7)] + costs[1];
            int cost30Day = dp[Math.max(0, i - 30)] + costs[2];

            dp[i] = Math.min(cost1Day, Math.min(cost7Day, cost30Day));
        }

        return dp[lastDay];
    }

    public static void main(String[] args) {
        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println(minCostTickets(days1, costs1)); // Output: 11

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println(minCostTickets(days2, costs2)); // Output: 17
    }

}
