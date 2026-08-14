/** problem: Lexicographical Numbers
 * 
 * approach 1: greedy
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * explanation:
 * 1. use a list to store the lexicographical numbers
 * 2. use a pointer to iterate through the numbers
 * 3. return the result
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int cur = 1;
        while (res.size() < n) {
            res.add(cur);
            if (cur * 10 <= n) cur *= 10;
            else {
                while (cur == n || cur % 10 == 9) {
                    cur /= 10;
                }
                cur++;
            }
        }
        return res;
    }
}
