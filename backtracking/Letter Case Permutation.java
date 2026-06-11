/**
 * Problem: Letter Case Permutation
 * Platform: LeetCode
 *
 * Approach (Backtracking):
 * 1. Use a backtracking approach to find the letter case permutation.
 * 2. Use a helper function to find the letter case permutation.
 * 3. Use a loop to iterate through the string and find the letter case permutation.
 * 4. Return the letter case permutation.
 */
/**
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a backtracking approach to find the letter case permutation.
 * 2. We use a helper function to find the letter case permutation.
 * 3. We use a loop to iterate through the string and find the letter case permutation.
 * 4. We return the letter case permutation.
 */
class Solution {
    private HashMap<Character, Character> map;
    ArrayList<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, Character.toUpperCase(c));
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, Character.toLowerCase(c));
        }
        dfs(0, s, new StringBuilder());
        return res;

    }
    private void dfs(int idx, String s, StringBuilder sb) {
        if (idx == s.length()) {
            res.add(sb.toString());
            return;
        }
        if (!map.containsKey(s.charAt(idx))) {
            sb.append(s.charAt(idx));
            dfs(idx+1, s, sb);
            sb.deleteCharAt(sb.length() - 1);
            
        }else {
            sb.append(s.charAt(idx));
            dfs(idx+1, s, sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(map.get(s.charAt(idx)));
            dfs(idx+1, s, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
