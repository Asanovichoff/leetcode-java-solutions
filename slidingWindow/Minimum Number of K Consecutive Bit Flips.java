/**
 * problem: 995. Minimum Number of K Consecutive Bit Flips
 * platform: LeetCode
 * approach:
 * 1. We can solve this problem using a greedy approach.
 * 2. We will maintain a reference to the input array `nums` and the integer `k`, and define a function `minKBitFlips(nums, k)` 
 * that computes the minimum number of k consecutive bit flips required to make all elements in the array equal to 1.  
 * 3. We will iterate through the array and keep track of the current number of flips using a variable `cur`.
 * 4. For each index `i`, we will check if the current element is 0 after considering the flips. If it is, we will perform a flip operation by incrementing
 * `cur` and updating the `flip` array to indicate that a flip has occurred at index `i + k`. We will also increment the result counter `res`.
 * 5. If the current element is 1 after considering the flips, we will continue to the next index without performing any flips.
 * 6. If we reach an index where a flip is required but there are not enough elements remaining in the array to perform a flip, we will return -1 to indicate that it is not possible to make all elements equal to 1.
 * 7. Finally, we will return the total number of flips performed, which is stored in the variable `res`.
 * 
 * time complexity: O(n), where n is the number of elements in the input array `nums`, as we iterate through the array once.
 * space complexity: O(n), where n is the number of elements in the input array `nums`, which is the space required for the `flip` array used to track the flips.
 */

class Solution {
    private int[] nums;
    private int k;
    public int minKBitFlips(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int res = 0;
        int[] flip = new int[nums.length + 1];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur +=flip[i];
            if ((nums[i] + cur) % 2 == 1) continue;
            if (i + k > nums.length) return -1;
            cur++;
            flip[i+k] -=1;
            res++;
        }
        return res;
    }
}