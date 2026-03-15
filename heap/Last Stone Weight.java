/**
 * Problem: Last Stone Weight
 * Platform: LeetCode
 *
 * Approach (Heap):
 * 1. Use a heap to store the stones.
 * 2. Use a loop to iterate through the stones and smash the stones.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n log n)
class Solution {
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a heap to store the stones.
 * 2. We use a loop to iterate through the stones and smash the stones.
 * 3. We return the result.
 */
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones){
            maxHeap.add(stone);
        }
        while (maxHeap.size()>1){
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();
            if(firstStone-secondStone!=0) maxHeap.add(firstStone-secondStone);
        }
        if(maxHeap.size()==0) return 0;
        else return maxHeap.peek();
    }
}
