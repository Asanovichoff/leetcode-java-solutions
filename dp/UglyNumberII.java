/**
 * Problem: Ugly Number II
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming array to store the ugly numbers.
 * 2. Use a loop to iterate through the array and find the ugly numbers.
 * 3. Return the nth ugly number.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
/**
 * Explanation:
 * 1. We use a dynamic programming array to store the ugly numbers.
 * 2. We use a loop to iterate through the array and find the ugly numbers.
 * 3. We return the nth ugly number.
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i<n; i++) {
            int minNum = Math.min(result[i2]*2,result[i3]*3);
            minNum = Math.min(minNum,result[i5]*5);
            result[i] = minNum;
            if (result[i2]*2 == minNum) i2++;
            if (result[i3]*3 == minNum) i3++;
            if (result[i5]*5 == minNum) i5++;
        }
        return result[n-1];

    }
}
