/**
 * Problem: Reverse Integer
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a while loop to iterate through the digits of the number.
 * 2. Use a modulo operator to get the last digit of the number.
 * 3. Use a division operator to remove the last digit of the number.
 * 4. Return the result.
 */

/**
 * Time Complexity: O(log(x))
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a while loop to iterate through the digits of the number.
 * 2. We use a modulo operator to get the last digit of the number.
 * 3. We use a division operator to remove the last digit of the number.
 * 4. We return the result.
 */

class Solution {
    public int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int digit = x % 10;

            if (reversed > Integer.MAX_VALUE / 10 ||
               (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            if (reversed < Integer.MIN_VALUE / 10 ||
               (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return reversed;
    }
}
