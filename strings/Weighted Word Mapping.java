/**
 * Problem: Weighted Word Mapping
 * Platform: LeetCode
 *
 * Approach (String Manipulation):
 * 1. Use a string manipulation approach to map the words to the weighted words.
 * 2. Use a loop to iterate through the words and map the words to the weighted words.
 * 3. Return the mapped words.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a string manipulation approach to map the words to the weighted words.
 * 2. We use a loop to iterate through the words and map the words to the weighted words.
 * 3. We return the mapped words.
 */
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int weight = 0;
            for (char c : word.toCharArray()) {
                weight += weights[c - 'a'];
            }
            int mod = weight % 26;
            sb.append((char) ('z' - mod));
        }

        return sb.toString();
    }
}