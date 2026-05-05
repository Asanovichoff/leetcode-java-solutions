/**
 * Problem: Kth Smallest Element in a Sorted Matrix
 * Platform: LeetCode
 *
 * Approach (Heap):
 * 1. Use a heap to store the elements of the matrix.
 * 2. Use a loop to iterate through the heap and find the kth smallest element.
 * 3. Return the kth smallest element.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a heap to store the elements of the matrix.
 * 2. We use a loop to iterate through the heap and find the kth smallest element.
 * 3. We return the kth smallest element.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for (int r = 0; r<matrix.length; r++) {
            pq.offer(new int[]{matrix[r][0], r, 0});
        }
        while(k-- > 1 && !pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[2]<matrix[0].length-1) {
                pq.offer(new int[]{matrix[arr[1]][arr[2]+1],arr[1], arr[2]+1});
            }
        }
        int result[] = pq.poll();
        return result[0]; 
    }
}