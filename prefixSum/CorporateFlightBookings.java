/**
 * Problem: Corporate Flight Bookings
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a prefix sum to calculate the number of seats booked for each flight.
 * 2. Use a loop to iterate through the bookings and calculate the number of seats booked for each flight.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a prefix sum to calculate the number of seats booked for each flight.
 * 2. We use a loop to iterate through the bookings and calculate the number of seats booked for each flight.
 * 3. We return the result.
 */

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] booking : bookings) {
            int first = booking[0] - 1;
            int last = booking[1] - 1;
            int seats = booking[2];

            result[first] += seats;

            if (last + 1 < n) {
                result[last + 1] -= seats;
            }
        }

        // Build prefix sum
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}