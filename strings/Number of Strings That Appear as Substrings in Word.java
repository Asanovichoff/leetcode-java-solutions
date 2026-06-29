/**
 * Problem: Number of Strings That Appear as Substrings in Word
 * Platform: LeetCode
 *
 * Approach (String Manipulation):
 * 1. Use a string manipulation approach to find the number of strings that appear as substrings in the word.
 * 2. Use a loop to iterate through the patterns and find the number of strings that appear as substrings in the word.
 * 3. Return the number of strings that appear as substrings in the word.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a string manipulation approach to find the number of strings that appear as substrings in the word.
 * 2. We use a loop to iterate through the patterns and find the number of strings that appear as substrings in the word.
 * 3. We return the number of strings that appear as substrings in the word.
 */
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                res++;
            }
        }
        return res;
    }
}
