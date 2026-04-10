/**
 * Problem: Car Fleet
 * Platform: LeetCode
 *
 * Approach (Array):
 * 1. Use an array to store the position and speed of the cars.
 * 2. Use a loop to iterate through the array and store the position and speed of the cars.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use an array to store the position and speed of the cars.
 * 2. We use a loop to iterate through the array and store the position and speed of the cars.
 * 3. We return the result.
 */
class Solution {
    class Pair{
        int val;
        int s;
        Pair(int val, int s){
            this.val = val;
            this.s = s;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0) return 0;
        
        Pair[] arr = new Pair[position.length];
        for (int i = 0; i<position.length; i++){
            arr[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(arr, (a,b) -> b.val-a.val);
        double prevTime = 0;
        int fleets = 0;

        for (Pair p : arr) {
            double time = (target - p.val) / (double) p.s;
            if (time > prevTime) {
                fleets++;
                prevTime = time;
            }
        }
        return fleets;
    }
}    