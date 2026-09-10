/** problem: Distinct Subsequences
 * 
 * approach 1: dfs
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 * 
 * explanation:
 * 1. use a memoization table to store the results of the subproblems
 * 2. use a pointer to iterate through the strings
 * 3. return the result
 */

class Solution {
    private String s;
    private String t;
    private Integer[][] cache;
    public int numDistinct(String s, String t) {
        cache = new Integer[s.length()][t.length()];
        this.s = s;
        this.t = t;
        dfs(0,0);
        return cache[0][0];
    }
    private int dfs (int idxS, int idxT) {
        if (idxT == t.length()) return 1;
        if (idxS == s.length()) return 0;
        if (cache[idxS][idxT] != null) return cache[idxS][idxT];
        if (s.charAt(idxS) == t.charAt(idxT)) {
            cache[idxS][idxT] = dfs(idxS + 1, idxT + 1) + dfs(idxS + 1, idxT);
        }else cache[idxS][idxT] = dfs(idxS + 1, idxT);
        return cache[idxS][idxT];
    }
}