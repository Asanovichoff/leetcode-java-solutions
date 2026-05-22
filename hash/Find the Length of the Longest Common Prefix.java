/**
 * Problem: Find the Length of the Longest Common Prefix
 * Platform: LeetCode
 *
 * Approach (Hash Table):
 * 1. Use a hash table to store the numbers in the first array.
 * 2. Use a loop to iterate through the second array and find the longest common prefix.
 * 3. Return the longest common prefix.
 */

/**
 * Time Complexity: O(m+n)
 * Space Complexity: O(m * 10^k) where k is the number of digits in the largest number in the first array
 * 
 * Explanation:
 * 1. We use a hash table to store the numbers in the first array.
 * 2. We use a loop to iterate through the second array and find the longest common prefix.
 * 3. We return the longest common prefix.
 */
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            while (num > 9) {
                set.add(num);
                num = num/10;
            }
            set.add(num);
        }
        int LCP = 0;
        for (int num : arr2) {
            while (num > 9) {
                if (set.contains(num)) {
                    LCP = Math.max(LCP, num);
                }
                num = num/10;
            } 
            if (set.contains(num)) {
                LCP = Math.max(LCP, num);
            }

        }
        if (LCP == 0) return 0; 
        int len = 1;
        while (LCP > 9) {
            len++;
            LCP/=10;
        }
        return len;
    }
}
