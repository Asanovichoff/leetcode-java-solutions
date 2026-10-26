class Solution {
    public long maxAlternatingSum(int[] nums) {
        long res = 0; 
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        while (l < r) {
            res += (nums[r] * nums[r]) - (nums[l] * nums[l]);
            l++;
            r--;
        }
        if (l == r) {
            res += nums[r] * nums[r];
        }
        return res;
    }
}