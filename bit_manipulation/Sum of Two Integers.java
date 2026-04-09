/**
 * Problem: Sum of Two Integers
 * Platform: LeetCode
 *
 * Approach (Bit Manipulation):
 * 1. Use a bit manipulation to sum the two integers.
 * 2. Use a loop to iterate through the integers and sum the two integers.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a bit manipulation to sum the two integers.
 * 2. We use a loop to iterate through the integers and sum the two integers.
 * 3. We return the result.
 */
class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}