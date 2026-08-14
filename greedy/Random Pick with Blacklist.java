/** problem: Random Pick with Blacklist
 * 
 * approach 1: greedy
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * explanation:
 * 1. use a set to store the blacklist
 * 2. use a random number generator to generate a random number
 * 3. return the random number
 */
class Solution {
    private HashSet<Integer> set;
    private final int n;
    public Solution(int n, int[] blacklist) {
        this.n = n;
        set = new HashSet<>();
        for (int num : blacklist) set.add(num);
    }
    
    public int pick() {
        Random random = new Random();
        while (true) {
            int x = random.nextInt(n);
            if (!set.contains(x)) return x;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */