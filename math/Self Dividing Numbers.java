/** problem: Self Dividing Numbers
 * 
 * approach 1: brute force
 * time complexity: O(n * log(num))
 * space complexity: O(1)
 * 
 * explanation:
 * 1. iterate through the range from left to right
 * 2. check if the number is a self dividing number
 * 3. return the result
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            int temp = num;
            boolean isPossible = true;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 0 || num % digit != 0) {
                    isPossible = false;
                    break;
                }
                temp /= 10;
            }
            if (isPossible) {
                result.add(num);
            }
        }

        return result;
    }
}