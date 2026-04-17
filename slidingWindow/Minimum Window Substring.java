/**
 * Problem: Minimum Window Substring
 * Platform: LeetCode
 *
 * Approach (Sliding Window):
 * 1. Use a sliding window to keep track of the characters in the substring.
 * 2. Use a loop to iterate through the string and keep track of the characters in the substring.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a sliding window to keep track of the characters in the substring.
 * 2. We use a loop to iterate through the string and keep track of the characters in the substring.
 * 3. We return the result.
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int formed = 0;
        int required = need.size();

        Map<Character, Integer> window = new HashMap<>();

        int[] ans = {-1, 0, 0}; // length, left, right

        while (r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) &&
                window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}