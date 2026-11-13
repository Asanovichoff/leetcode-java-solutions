class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        int count = 0;
        int start = 0;

        while (count < n) {
            int current = start;
            int prev = nums[start];

            while (true) {
                int next = (current + k) % n;

                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                current = next;
                count++;

                if (current == start) {
                    break;
                }
            }

            start++;
        }
    }
}