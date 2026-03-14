/**
 * Problem: Permutation in String
 * Platform: LeetCode
 *
 * Approach (Sliding Window):
 * 1. Use a sliding window to check if the permutation of s1 is in s2.
 * 2. Use a loop to iterate through the string and check if the permutation of s1 is in s2.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a sliding window to check if the permutation of s1 is in s2.
 * 2. We use a loop to iterate through the string and check if the permutation of s1 is in s2.
 * 3. We return the result.
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if (allZero(count)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {

            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;

            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] arr){
        for(int n : arr){
            if(n != 0) return false;
        }
        return true;
    }
}
