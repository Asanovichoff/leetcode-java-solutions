/**
 * Problem: Partition Array According to Given Pivot
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use two pointers to find the partition array.
 * 2. Use a loop to iterate through the array and find the partition array.
 * 3. Return the partition array.
 */
/**
 * Time Complexity: O(n)
class Solution {
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use two pointers to find the partition array.
 * 2. We use a loop to iterate through the array and find the partition array.
 * 3. We return the partition array.
 */
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greter = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) less.add(num);
            else if (num == pivot) equal.add(num);
            else greter.add(num);
        }
        int i = 0;
        for (int num : less) {
            nums[i] = num;
            i++;
        }
        for (int num : equal) {
            nums[i] = num;
            i++;
        }
        for (int num : greter) {
            nums[i] = num;
            i++;
        }
        return nums;

    }
}
