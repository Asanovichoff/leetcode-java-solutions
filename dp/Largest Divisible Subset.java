/** problem: Largest Divisible Subset
 * 
 * approach 1: dynamic programming
 * time complexity: O(n^2)
 * space complexity: O(n)
 * 
 * explanation:
 * 1. sort the array
 * 2. use a list to store the largest divisible subset
 * 3. use a nested loop to iterate through the array
 * 4. if the current number is divisible by the previous number, then add the current number to the subset
 * 5. return the largest subset
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] dp = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0) {
                    if (dp[j].size() + 1 > dp[i].size()) {
                        dp[i] = new ArrayList<>(dp[j]);
                        dp[i].add(nums[i]);
                    }
                }
            }
            if (dp[i].size() > res.size()) res = dp[i];
        }
        return res;
    }
}