/**
 * Problem: Angle Between Hands of a Clock
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a math approach to calculate the angle between the hands of the clock.
 * 2. Use a loop to iterate through the clock and calculate the angle between the hands of the clock.
 * 3. Return the angle between the hands of the clock.
 */
/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a math approach to calculate the angle between the hands of the clock.
 * 2. We use a loop to iterate through the clock and calculate the angle between the hands of the clock.
 * 3. We return the angle between the hands of the clock.
 */
class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle = minutes*6;
        double hourAngle = (hour % 12) * 30.0 + (minutes * 0.5);

        double diff = Math.abs(hourAngle-minAngle);
        return Math.min(diff, 360-diff);
    }
}
