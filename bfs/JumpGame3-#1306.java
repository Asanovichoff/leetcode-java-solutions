/**
 * Problem: Jump Game III
 * Platform: LeetCode
 *
 * Approach (Breadth-First Search):
 * 1. Use a queue to keep track of the indices to visit.
 * 2. Use a set to keep track of the indices that have been visited.
 * 3. Use a loop to iterate through the queue and visit the indices.
 * 4. If the index is 0, return true.
 * 5. Otherwise, return false.
 *
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a queue to keep track of the indices to visit.
 * 2. We use a set to keep track of the indices that have been visited.
 * 3. We use a loop to iterate through the queue and visit the indices.
 * 4. If the index is 0, return true.
 * 5. Otherwise, return false.
 * 
 * 
 * 
 */
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                int idx = queue.poll();
                if(arr[idx]==0) return true;
                if(idx+arr[idx]<arr.length && !visited.contains(idx+arr[idx])){
                    queue.add(idx+arr[idx]);
                    visited.add(idx+arr[idx]);
                }
                if(idx-arr[idx]>=0 && !visited.contains(idx-arr[idx])){
                    queue.add(idx-arr[idx]);
                    visited.add(idx-arr[idx]);
                }
            }
        }
        return false;
    }
}