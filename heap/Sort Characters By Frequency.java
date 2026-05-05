/**
 * Problem: Sort Characters By Frequency
 * Platform: LeetCode
 *
 * Approach (Heap):
 * 1. Use a heap to store the characters and their frequencies.
 * 2. Use a loop to iterate through the heap and build the result string.
 * 3. Return the result string.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a heap to store the characters and their frequencies.
 * 2. We use a loop to iterate through the heap and build the result string.
 * 3. We return the result string.
 */
class Solution {
    class Pair {
        int count;
        char c;

        private Pair(char c, int count) {
            this.count = count;
            this.c = c;
        }
    }

    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.count, a.count)
        );

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Push into heap
        for (char key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();

        // Build result
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            for (int i = 0; i < pair.count; i++) {
                sb.append(pair.c);
            }
        }

        return sb.toString();
    }
}
