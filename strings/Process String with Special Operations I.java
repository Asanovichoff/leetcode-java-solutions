/**
 * Problem: Process String with Special Operations I
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
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                sb.append(sb.toString());
            } 
            else if (c == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } 
            else if (c == '%') {
                sb.reverse();
            } 
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
