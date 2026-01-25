/**
 * Problem: Number of Substrings Containing All Three Characters
 * Platform: LeetCode
 *
 * Approach (Sliding Window):
 * 1. Use a sliding window to keep track of the characters in the substring.
 * 2. Use a count array to keep track of the number of each character in the substring.
 * 3. Use a left pointer to keep track of the leftmost index of the substring.
 * 4. Use a result variable to keep track of the number of substrings.
 * 5. Return the result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)

 */
class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; 
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }
}
