/**
 * Problem: Minimize Array Sum Using Divisible Replacements
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a set to store the numbers in the array.
 * 2. Use a loop to iterate through the array and find the minimum number of replacements.
 * 3. Return the minimum number of replacements.
 */
/**
 * Time Complexity: O(n * sqrt(n))  
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a set to store the numbers in the array.
 * 2. We use a loop to iterate through the array and find the minimum number of replacements.
 * 3. We return the minimum number of replacements.
 */
class Solution {
    public long minArraySum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        long sum = 0;
        for (int x : nums) {
            int best = x;
            for (int d = 1; d * d <= x; d++) {
                if (x % d == 0) {
                    if (set.contains(d)) {
                        best = Math.min(best, d);
                    }
                    int other = x / d;
                    if (set.contains(other)) {
                        best = Math.min(best, other);
                    }
                }
            }
            sum += best;
        }
        return sum;
    }    
}
