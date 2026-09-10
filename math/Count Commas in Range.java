/**
 * Problem: Count Commas in Range
 * Platform: LeetCode
 *
 * Approach :
 * 1. Check if the input number n is less than 1000. If it is, return 0 since there are no commas in numbers less than 1000.
 * 2. If n is greater than or equal to 1000, calculate the number of integers from 1000 to n (inclusive) that contain commas. This can be done by
 */
/**
 * Time Complexity: O(1), as we are performing a constant time check and calculation.
 * Space Complexity: O(1), as we are using a constant amount of space.
 */

class Solution {
    public int countCommas(int n) {
        if (n < 1000) return 0;
        return n - 1000 + 1;
    }
}
