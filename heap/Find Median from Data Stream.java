/**
 * Problem: Find Median from Data Stream
 * Platform: LeetCode
 *
 * Approach (Heap):
 * 1. Use a heap to store the numbers.
 * 2. Use a loop to iterate through the numbers and find the median.
 * 3. Return the median.
 */
/**
 * Time Complexity: O(log n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a heap to store the numbers.
 * 2. We use a loop to iterate through the numbers and find the median.
 * 3. We return the median.
 */
class MedianFinder {
    PriorityQueue<Integer> minHeap; 
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}
