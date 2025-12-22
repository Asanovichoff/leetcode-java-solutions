/**
 * Problem: Jump Game IV
 * Platform: LeetCode
 *
 * Approach (Breadth-First Search):
 * 1. Use a queue to keep track of the indices to visit.
 * 2. Use a set to keep track of the indices that have been visited.
 * 3. Use a loop to iterate through the queue and visit the indices.
 * 4. If the index is the last index, return true.
 * 5. Otherwise, return false.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a queue to keep track of the indices to visit.
 * 2. We use a set to keep track of the indices that have been visited.
 * 3. We use a loop to iterate through the queue and visit the indices.
 * 4. If the index is the last index, return true.
 * 5. Otherwise, return false.
 * 
 * 
 */
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0; // edge case

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int idx = q.poll();
                if (idx == n - 1) return steps;
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.add(idx - 1);
                }
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.add(idx + 1);
                }

                // same value jumps
                if (map.containsKey(arr[idx])) {
                    for (int next : map.get(arr[idx])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                    map.remove(arr[idx]);
                }
            }
            steps++;
        }
        return -1;
    }
}
