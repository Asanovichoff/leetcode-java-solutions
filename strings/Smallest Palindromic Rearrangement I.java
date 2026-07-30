/**
 * Problem: Smallest Palindromic Rearrangement I
 * Platform: LeetCode
 *
 * Approach :
 * 1. Count the frequency of each character in the input string.
 * 2. Construct the left half of the palindrome by appending half of the frequency of each character to a StringBuilder.
 * 3. If there is a character with an odd frequency, set it as the middle character of the palindrome.
 * 4. Construct the right half of the palindrome by reversing the left half and appending it to the StringBuilder.
 * 5. Return the final palindrome string.
 */
/**
 * Time Complexity: O(n), where n is the length of the input string.
 * Space Complexity: O(1), since the frequency array has a fixed size of 26 for lowercase English letters.
 */

class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if (count[i] % 2 == 1) {
                middle = String.valueOf((char) ('a' + i));
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(middle);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}