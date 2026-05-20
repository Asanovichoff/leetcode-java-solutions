/**
 * Problem: Minimum Common Value
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use two pointers to find the minimum common value.
 * 2. Use a loop to iterate through the arrays and find the minimum common value.
 * 3. Return the minimum common value.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use two pointers to find the minimum common value.
 * 2. We use a loop to iterate through the arrays and find the minimum common value.
 * 3. We return the minimum common value.
 */
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = 0, n2 = 0;
        while (n1<nums1.length && n2<nums2.length) {
            if (nums1[n1] == nums2[n2]) return nums1[n1];
            else if (nums1[n1] < nums2[n2]) n1++;
            else n2++;
        }
        return -1;
    }
}
