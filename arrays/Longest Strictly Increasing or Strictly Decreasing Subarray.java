class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int sI = 0;
        int inc = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) inc++;
            else {
                sI = Math.max(sI, inc);
                inc = 0;
            }
        }
        sI = Math.max(sI, inc);
        int sD = 0;
        int dec = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) dec++;
            else {
                sD = Math.max(sD, dec);
                dec = 0;
            }
        }
        sD = Math.max(sD, dec);
        return Math.max(sI, sD) + 1;
    }
}