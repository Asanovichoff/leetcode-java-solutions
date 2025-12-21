/*

 * Problem: Jump Game VII
 * Platform: LeetCode
 *
 * Approach (Breadth-First Search):
 * 1. Use a queue to keep track of the indices to visit.
 * 2. Use a set to keep track of the indices that have been visited.
 * 3. Use a loop to iterate through the queue and visit the indices.
 * 4. If the index is the last index, return true.
 * 5. Otherwise, return false.
 * 
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
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') return false;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int farthest = 0;

        while (!q.isEmpty()) {
            int idx = q.poll();

            int start = Math.max(idx + minJump, farthest + 1);
            int end = Math.min(idx + maxJump, s.length() - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    if (j == s.length() - 1) return true;
                    q.add(j);
                }
            }

            farthest = Math.max(farthest, idx + maxJump);
        }

        return false;
    }
}