/**
 * Problem: H-Index
 * Platform: LeetCode
 *
 * Approach (Sorting):
 * 1. Sort the citations array.
 * 2. Use a loop to iterate through the citations array and find the h-index.
 * 3. Return the h-index.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We sort the citations array.
 * 2. We use a loop to iterate through the citations array and find the h-index.
 * 3. We return the h-index.
 */
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}