/**
 * Problem: Flip String to Monotone Increasing
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the minimum number of flips to make the string monotone increasing.
 * 2. Use a loop to iterate through the string and find the minimum number of flips to make the string monotone increasing.
 * 3. Return the minimum number of flips to make the string monotone increasing.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the minimum number of flips to make the string monotone increasing.
 * 2. We use a loop to iterate through the string and find the minimum number of flips to make the string monotone increasing.
 * 3. We return the minimum number of flips to make the string monotone increasing.
 */
class Solution {
    public int minFlipsMonoIncr(String s) {
        int result = 0;
        int countOfOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') countOfOnes++;
            else result = Math.min(countOfOnes, 1+result);
        }
        return result;
    }

}
