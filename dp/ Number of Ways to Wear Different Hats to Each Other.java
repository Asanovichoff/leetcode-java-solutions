/**
 * Problem: Number of Ways to Wear Different Hats to Each Other
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to calculate the number of ways to wear different hats to each other.
 * 2. Use a loop to iterate through the hats and calculate the number of ways to wear different hats to each other.
 * 3. Return the number of ways to wear different hats to each other.
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();

        // hat -> list of people
        List<Integer>[] hatToPeople = new List[41];
        for (int i = 1; i <= 40; i++) {
            hatToPeople[i] = new ArrayList<>();
        }

        for (int person = 0; person < n; person++) {
            for (int hat : hats.get(person)) {
                hatToPeople[hat].add(person);
            }
        }

        Integer[][] dp = new Integer[41][1 << n];

        return dfs(1, 0, hatToPeople, dp, n);
    }

    private int dfs(int hat, int mask, List<Integer>[] hatToPeople,
                    Integer[][] dp, int n) {

        if (mask == (1 << n) - 1) return 1;
        if (hat > 40) return 0;

        if (dp[hat][mask] != null) return dp[hat][mask];

        int ways = 0;

        // skip this hat
        ways = dfs(hat + 1, mask, hatToPeople, dp, n);

        // assign this hat
        for (int person : hatToPeople[hat]) {
            if ((mask & (1 << person)) == 0) {
                ways = (ways + dfs(hat + 1, mask | (1 << person),
                        hatToPeople, dp, n)) % MOD;
            }
        }

        return dp[hat][mask] = ways;
    }
}