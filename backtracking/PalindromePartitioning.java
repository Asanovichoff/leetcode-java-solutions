/**
 * Problem: Palindrome Partitioning
 * Platform: LeetCode
 *
 * Approach (Backtracking):
 * 1. Use a backtracking approach to partition the string into palindromes.
 * 2. Use a helper function to check if the substring is a palindrome.
 * 3. Use a loop to iterate through the string and partition the string into palindromes.
 * 4. Return the result.
 */
/**

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a backtracking approach to partition the string into palindromes.
 * 2. We use a helper function to check if the substring is a palindrome.
 * 3. We use a loop to iterate through the string and partition the string into palindromes.
 * 4. We return the result.
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, res);
        return res;
    }

    public void dfs(int start, String s, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                dfs(end + 1, s, path, res);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
