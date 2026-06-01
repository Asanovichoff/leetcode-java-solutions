/**
 * Problem: Relative Sort Array
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use two pointers to find the relative sort array.
 * 2. Use a loop to iterate through the array and find the relative sort array.
 * 3. Return the relative sort array.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use two pointers to find the relative sort array.
 * 2. We use a loop to iterate through the array and find the relative sort array.
 * 3. We return the relative sort array.
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int i = 0;
        int idxOfarr2 = 0;
        while (idxOfarr2 < arr2.length) {
            for (int j = i; j < arr1.length; j++) {
                if (arr1[j] == arr2[idxOfarr2]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                    i++;
                }
            }
            idxOfarr2++;
        }
        Arrays.sort(arr1, i, arr1.length);
        return arr1;
    }
}