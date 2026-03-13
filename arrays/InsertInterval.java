/**
 * Problem: Insert Interval
 * Platform: LeetCode
 *
 * Approach (Array):
 * 1. Use an array to insert the new interval into the intervals.
 * 2. Use a loop to iterate through the intervals and insert the new interval.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)

 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use an array to insert the new interval into the intervals.
 * 2. We use a loop to iterate through the intervals and insert the new interval.
 * 3. We return the result.
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        boolean isAdded = false;
        for (int[] interval: intervals){
            if (!isAdded){
                if (newInterval[1]<interval[0]){
                    list.add(newInterval);
                    list.add(interval);
                    isAdded = true;
                } else if (newInterval[0] > interval[1]){
                    list.add(interval);
                } else if (newInterval[1] < interval[0]) {
                    list.add(newInterval);
                    list.add(interval);
                    isAdded = true;
                } else{
                    newInterval[0] = Math.min(newInterval[0],interval[0]);
                    newInterval[1] = Math.max(newInterval[1],interval[1]);
                }
            }else{
                list.add(interval);
            }
        }
        if (!isAdded) list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
