/**
 * Problem: My Calendar
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a prefix sum to find the overlaping array.
 * 2. Use a loop to iterate through the array and find the overlaping array.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
/**
 * Explanation:
 * 1. We use a prefix sum to find the overlaping array.
 * 2. We use a loop to iterate through the array and find the overlaping array.
 * 3. We return the result.
 */
class MyCalendar {
    private ArrayList<int[]> overlapingArray;
    public MyCalendar() {
        overlapingArray = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] time : overlapingArray) {
            if (endTime > time[0] && startTime < time[1]) return false;
        }
        overlapingArray.add(new int[]{startTime, endTime});
        return true;
    }
}