/**
 * Problem: Non-overlapping Intervals
 * Platform: LeetCode
 *
 * Intuition:
 * We want to remove the minimum number of intervals to make the rest of the intervals non-overlapping.
 * We can do this by sorting the intervals by the end time and then iterating through the intervals and removing the intervals that overlap with the previous interval.
 * This is a greedy algorithm because we are always making the best choice at each step.
 * 
 * Approach (Greedy):
 * 1. Sort the intervals by the end time.
 * 2. Iterate through the intervals and remove the intervals that overlap with the previous interval.
 * 3. Return the number of intervals removed.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                removals++; // overlap → remove current interval
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
