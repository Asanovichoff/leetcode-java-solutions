/**
 * Problem: Counting Bits
 * Platform: LeetCode
 *
 * Approach (Bit Manipulation):
 * 1. Use a bit manipulation to count the number of bits in the number.
 * 2. Use a loop to iterate through the numbers and count the number of bits in the number.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a bit manipulation to count the number of bits in the number.
 * 2. We use a loop to iterate through the numbers and count the number of bits in the number.
 * 3. We return the result.
 */
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 1; i<=n; i++){
            result[i] = result[i >> 1]+(i & 1);
        }
        return result;
    }
}
