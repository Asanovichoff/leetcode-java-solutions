/** problem Count and Say
 * 
 * approach 1: iterative
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 * explanation:
 * 1. initialize the previous string as "1"
 * 2. for each iteration, count the number of consecutive digits in the previous string
 * 3. append the count and the digit to the current string
 * 4. return the current string
 */

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder prev = new StringBuilder();
        prev.append('1');
        for (int i = 1; i < n; i++) {
            StringBuilder curr = new StringBuilder();

            int idx = 0;
            while (idx < prev.length()) {
                char digit = prev.charAt(idx);
                int count = 0;

                while (idx < prev.length() && prev.charAt(idx) == digit) {
                    count++;
                    idx++;
                }
                curr.append(count);
                curr.append(digit);
            }
            prev = curr;
        }
        return prev.toString();
    }
}