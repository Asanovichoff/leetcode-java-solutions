/**
 * Problem: Can I Win
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a memoization array to store the results of the subproblems.
 * 2. Use a dfs function to recursively calculate the result.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n^2)
class Solution {
 * Space Complexity: O(n^2)
 * 
 * Explanation:
 * 1. If the desiredTotal is 0, the current player can win.
 * 2. If the maxChoosableInteger is greater than or equal to the desiredTotal, the current player can win.
 * 3. If the sum of the first maxChoosableInteger numbers is less than the desiredTotal, the current player can not win.
 * 4. We use a boolean array to store the numbers that have been used.
 * 5. We use a map to store the results of the subproblems.
 * 6. We use a dfs function to recursively calculate the result.
 * 7. We return the result.
 */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal<=0) return true;
        if (maxChoosableInteger >= desiredTotal) return true;
        if (((maxChoosableInteger+1)*maxChoosableInteger)/2<desiredTotal) return false;

        boolean[] used = new boolean[maxChoosableInteger + 1]; 
        Map<String, Boolean> memo = new HashMap<>();

        return dfs(desiredTotal, used, memo, maxChoosableInteger);        
    }
    public boolean dfs(int remaining, boolean[] used, Map<String, Boolean> memo, int max){

        String key = buildKey(used);
        if (memo.containsKey(key)) return memo.get(key);

        for (int i = 1; i <=max; i++){
            if(used[i]) continue;
            used[i] = true;

            if(i >= remaining){
                used[i] = false;
                memo.put(key, true);
                return true;
            }

            boolean opponentCanWins = dfs(remaining-i, used, memo, max);

            used[i] = false;
            if(!opponentCanWins){
                memo.put(key, true);
                return true;
            }
        }  
        memo.put(key, false);
        return false;      
    }
    public String buildKey(boolean[] used) {
        StringBuilder sb = new StringBuilder(used.length);

        for (int i = 1; i < used.length; i++) {
            sb.append(used[i] ? '1' : '0');
        }

        return sb.toString();
    }
}
