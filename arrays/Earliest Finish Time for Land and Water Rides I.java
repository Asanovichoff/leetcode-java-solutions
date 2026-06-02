/**
 * Problem: Earliest Finish Time for Land and Water Rides I
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use two pointers to find the earliest finish time for the land and water rides.
 * 2. Use a loop to iterate through the land and water rides and find the earliest finish time.
 * 3. Return the earliest finish time.
 */
/**
 * Time Complexity: O(n*m)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use two pointers to find the earliest finish time for the land and water rides.
 * 2. We use a loop to iterate through the land and water rides and find the earliest finish time.
 * 3. We return the earliest finish time.
 */
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int landStart = landStartTime[i];
            int landEnd = landStart + landDuration[i];

            for (int j = 0; j < m; j++) {
                int waterStart = waterStartTime[j];
                int waterEnd = waterStart + waterDuration[j];

                int startWaterAfterLand = Math.max(landEnd, waterStart);
                result = Math.min(result, startWaterAfterLand + waterDuration[j]);

                int startLandAfterWater = Math.max(waterEnd, landStart);
                result = Math.min(result, startLandAfterWater + landDuration[i]);
            }
        }

        return result;
    }
}
