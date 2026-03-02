/**
 * Problem: Find the Difference
 * Platform: LeetCode
 *
 * Approach (Bit Manipulation):
 * 1. Use a bit manipulation to find the difference between the two strings.
 * 2. Use a for loop to iterate through the strings.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a bit manipulation to find the difference between the two strings.
 * 2. We use a for loop to iterate through the strings.
 * 3. We return the result.
 */ 
class Solution {
    public char findTheDifference(String s, String t) {
        char letter = 0;
        for(char c: t.toCharArray()){
            letter ^=c;
        }
        for(char c: s.toCharArray()){
            letter ^=c;
        }
        return letter;

    }
}