/**
 * problem: https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
 * approach: greedy
 * 1. We can solve this problem using a greedy approach.
 * 2. We will maintain a reference to the input string `s` and define a function `maxPalindromes(s, k)` that computes the maximum number of non-overlapping palindrome substrings of length at least `k`.
 * 3. We will iterate through the string                
 *  4. For each index `r`, we will check if there exists a palindrome substring of length at least `k` that ends at index `r`. If such a substring exists, we will increment the count of non-overlapping palindrome substrings and update the starting index for the next search.  
 * 5. We will continue this process until we reach the end of the string and return the count of non-overlapping palindrome substrings found.
 * time complexity: O(n * k), where n is the length of the input string `s` and k is the minimum length of the palindrome substrings, as we may need to check up to k characters for each index in the string.
 * space complexity: O(1), as we are not using any additional data structures that scale with the input size.   
 */
class Solution {
    private String s;
    public int maxPalindromes(String s, int k) {
        this.s = s;
        int res = 0;
        int i = 0;
        for (int r = k-1; r < s.length(); r++) {
            int l1 = r - k + 1;
            if (l1 >= i && isPalindrome(l1, r)) {
                res++;
                i = r + 1;
                continue;
            }   
            int l2 = r - k;
            if (l2 >= i && isPalindrome(l2, r)) {
                res++;
                i = r + 1;
            }
        }
        return res;
    }
    private boolean isPalindrome (int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}