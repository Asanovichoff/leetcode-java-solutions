/** problem: Smallest Subsequence of Distinct Characters
 * 
 * approach 1: greedy
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * explanation:
 * 1. use a set to store the distinct characters
 * 2. use a pointer to iterate through the string
 * 3. return the result
 */
class Solution {
    public String smallestSubsequence(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char letter : s.toCharArray()) {
            set.add(letter);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (set.contains(c)) {
                sb.insert(c);
            }
        }
        return sb.toString();
    }
}