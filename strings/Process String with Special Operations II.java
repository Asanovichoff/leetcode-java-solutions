/**
 * Problem: Process String with Special Operations II
 * Platform: LeetCode
 *
 * Approach (String Manipulation):
 * 1. Use a string manipulation approach to process the string.
 * 2. Use a loop to iterate through the string and process the string.
 * 3. Return the processed string.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a string manipulation approach to process the string.
 * 2. We use a loop to iterate through the string and process the string.
 * 3. We return the processed string.
 */
class Solution {
        long len = 0;
        for (char c : s.toCharArray()) {
            if (c == '#') {
                len *=2;
            } 
            else if (c == '*') {
                if (len > 0) {
                    len--;
                }
            } 
            else if (c == '%') {
                continue;
            } 
            else {
                len++;
            }
        }
        if (k >= len) return '.';
        
        String reversed = new StringBuilder(s).reverse().toString();

        for (char c : reversed.toCharArray()) {
            if (c == '#') {
                len /= 2;
                k %= len;
            } else if (c == '*') {
                len++;
            } else if (c == '%') {
                k = len - 1 - k;
            } else {
                if (k == len - 1) return c;
                len--;
            }
        }
        return '.';
    }
}