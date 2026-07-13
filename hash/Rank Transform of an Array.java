class Solution {
    /** problem: Rank Transform of an Array
     * 
     * approach 1: hash map
     * time complexity: O(n log n)
     * space complexity: O(n)
     * 
     * explanation:
     * 1. sort the array
     * 2. create a hash map to store the rank of each number
     * 3. iterate through the array and assign the rank to each number
     * 4. return the array
     */
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int currentRank = 1;

        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, currentRank++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
}