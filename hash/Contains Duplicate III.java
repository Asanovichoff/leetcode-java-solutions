/**
 * Problem: Contains Duplicate III
 * Platform: LeetCode
 *
 * Approach (Tree Set):
 * 1. Use a tree set to store the numbers in the window.
 * 2. Use a loop to iterate through the numbers and check if there is a number in the window that is within the value difference.
 * 3. Return true if there is a number in the window that is within the value difference, otherwise return false.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a tree set to store the numbers in the window.
 * 2. We use a loop to iterate through the numbers and check if there is a number in the window that is within the value difference.
 * 3. We return true if there is a number in the window that is within the value difference, otherwise return false.
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> window = new TreeSet<>();
        for(int i = 0; i<nums.length; i++){
            long num = nums[i];
            Long ceiling = window.ceiling(num - valueDiff);
            if (ceiling != null && ceiling <= num + valueDiff) {
                return true;
            }
            window.add((long)nums[i]);
            if(window.size()>indexDiff) window.remove((long) nums[i-indexDiff]);
        }
        return false;
    }
}