class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp1 = costs[0] + 1;
        if (n == 1) return dp1;
        int dp2 = Math.min(
            dp1 + costs[1] + 1,
            costs[1] + 4
        );
        if (n == 2) return dp2;
        int dp3 = Math.min(
            Math.min(dp2 + costs[2] + 1,
                     dp1 + costs[2] + 4),
            costs[2] + 9
        );
        for (int i = 3; i < n; i++) {
            int dp4 = Math.min(
                Math.min(dp3 + costs[i] + 1,
                         dp2 + costs[i] + 4),
                dp1 + costs[i] + 9
            );
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp4;
        }
        return dp3;
    }
}