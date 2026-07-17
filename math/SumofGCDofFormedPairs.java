/** problem: Sum of GCD of formed pairs
 * 
 * approach 1: prefix gcd
 * time complexity: O(n log n)
 * space complexity: O(n)
 * 
 * explanation:
 * 1. initialize the prefix gcd array
 * 2. sort the prefix gcd array
 * 3. calculate the sum of gcd of formed pairs by two pointers
 * 4. return the result
 */
class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int maxNum = 0;
        int[] prefixGcd = new int[n];
        for (int i = 0; i < n; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            prefixGcd[i] = gcd(maxNum, nums[i]);
        }
        Arrays.sort(prefixGcd);
        long res = 0;
        int l = 0;
        int r = n-1;
        while (l < r) {
            res+= gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }
        return res;
    }
    private int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}