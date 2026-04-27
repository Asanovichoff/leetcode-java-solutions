/**
 * Problem: Car Pooling
 * Platform: LeetCode
 *
 * Approach (Heap):
 * 1. Use a heap to store the trips.
 * 2. Use a loop to iterate through the trips and store the trips in the heap.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
/**
 * Explanation:
 * 1. We use a heap to store the trips.
 * 2. We use a loop to iterate through the trips and store the trips in the heap.
 * 3. We return the result.
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int numsPassengers = 0;
        for (int[] trip : trips) {
            while (!minHeap.isEmpty() && minHeap.peek()[0]<=trip[1]) {
                int[] stop = minHeap.poll();
                numsPassengers-=stop[1];
            }
            numsPassengers+=trip[0];
            if (numsPassengers>capacity) return false;
            minHeap.offer(new int[]{trip[2],trip[0]});
        }
        return true;
    }
}