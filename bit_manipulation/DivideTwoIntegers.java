/**
 * Problem: Divide Two Integers
 * Platform: LeetCode
 *
 * Approach (Bit Manipulation):
 * 1. Use a bit manipulation to divide the two integers.
 * 2. Use a loop to iterate through the integers.
 * 3. Return the result.
 */

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. we handle edge case where dividend is a -2^31 and divisor is a -1, then we return the max value of integer.
 * 2. we check if the dividend and divisor are of the same sign, if not, we set the isNegative flag to true.
 * 3. we convert the dividend and divisor to long to avoid overflow.
 * 4. we use a while loop to divide the dividend by the divisor.
 * 5. we use a bit manipulation to divide the dividend by the divisor.
 * 6. we use a loop to iterate through the integers.
 * 7. we return the result.
 * 3. We return the result.
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = false;
        if(dividend>0 && divisor<0 || dividend<0 && divisor>0) isNegative = true;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        while(n>=d){
            int power = 0;
            while(n>=d<<(power+1)){
                power++;
            }
            result+=1<<power;
            n-= d<<power;
        }
        return isNegative ? -result: result; 
    }
}