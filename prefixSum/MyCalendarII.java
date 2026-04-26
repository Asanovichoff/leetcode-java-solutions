/**
 * Problem: My Calendar II
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a prefix sum to find the non-overlaping array.
 * 2. Use a loop to iterate through the array and find the non-overlaping array.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
/**
 * Explanation:
 * 1. We use a prefix sum to find the non-overlaping array.
 * 2. We use a loop to iterate through the array and find the non-overlaping array.
 * 3. We return the result.
 */
class MyCalendarTwo {
    private ArrayList<int[]> nonOverlapingArray;
    private ArrayList<int[]> overlapingArray;
    public MyCalendarTwo() {
        nonOverlapingArray = new ArrayList<>();
        overlapingArray = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] time : overlapingArray) {
            if (endTime > time[0] && startTime < time[1]) return false;
        }

        for (int[] time : nonOverlapingArray) {
            if (endTime > time[0] && startTime < time[1]) {
                overlapingArray.add(new int[]{Math.max(startTime, time[0]),Math.min(endTime, time[1])});
            }
        }
        nonOverlapingArray.add(new int[]{startTime, endTime});
        return true;
    }
}
