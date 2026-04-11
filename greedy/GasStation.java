/**
 * Problem: Gas Station
 * Platform: LeetCode
 *
 * Approach (Greedy):
 * 1. Use a greedy approach to find the starting gas station.
 * 2. Use a loop to iterate through the gas stations and find the starting gas station.
 * 3. Return the starting gas station.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a greedy approach to find the starting gas station.
 * 2. We use a loop to iterate through the gas stations and find the starting gas station.
 * 3. We return the starting gas station.
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int current = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            
            total += diff;
            current += diff;

            // If we can't reach station i+1
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }

        return total < 0 ? -1 : start;
    }
}
