/**
 * Problem: String to Integer
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a while loop to iterate through the string.
 * 2. Use a modulo operator to get the last digit of the number.
 * 3. Use a division operator to remove the last digit of the number.
 * 4. Return the result.
 */ 

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a while loop to iterate through the string.
 * 2. We use a modulo operator to get the last digit of the number.
 * 3. We use a division operator to remove the last digit of the number.
 * 4. We return the result.
 */

class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int result = 0;

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Check overflow BEFORE multiplying
            if (result > Integer.MAX_VALUE / 10 ||
               (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}