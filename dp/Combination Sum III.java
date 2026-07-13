/** problem: Combination Sum III
 * 
 * approach 1: dfs
 * time complexity: O(9^k)
 * space complexity: O(k)
 * 
 * explanation:
 * 1. initialize the result list
 * 2. call the dfs function
 * 3. return the result
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n, new ArrayList<>());
        return res;
    }

    private void dfs(int start, int k, int remaining, List<Integer> list) {
        if (list.size() == k) {
            if (remaining == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remaining) {
                break;
            }
            list.add(i);
            dfs(i + 1, k, remaining - i, list);
            list.remove(list.size() - 1);
        }
    }
}