package binSearch;
/**
 * Problem: Koko Eating Bananas
 * Platform: LeetCode
 *
 * Approach (Binary Search):
 * 1. Use a binary search to find the minimum eating speed.
 * 2. Use a loop to iterate through the piles and find the minimum eating speed.
 * 3. Return the minimum eating speed.
 */
/**
 * Time Complexity: O(n log m)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a binary search to find the minimum eating speed.
 * 2. We use a loop to iterate through the piles and find the minimum eating speed.
 * 3. We return the minimum eating speed.
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l <= r) {
            int m = l + (r - l) / 2;
            long hours = 0;

            for (int pile : piles) {
                hours += (pile + m - 1) / m; // ceiling division
                if (hours > h) break;
            }

            if (hours <= h) {
                r = m - 1; 
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}