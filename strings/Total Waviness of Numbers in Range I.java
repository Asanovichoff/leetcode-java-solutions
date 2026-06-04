/**
class Solution {
 * Problem: Total Waviness of Numbers in Range I
 * Platform: LeetCode
 *
 * Approach (String Manipulation):
 * 1. Use a string manipulation approach to count the total waviness of numbers in a range.
 * 2. Use a loop to iterate through the numbers and count the total waviness of numbers in a range.
 * 3. Return the total waviness of numbers in a range.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a string manipulation approach to count the total waviness of numbers in a range.
 * 2. We use a loop to iterate through the numbers and count the total waviness of numbers in a range.
 * 3. We return the total waviness of numbers in a range.
 */
    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            total += count(num);
        }

        return total;
    }

    private int count(int num) {
        String s = String.valueOf(num);

        if (s.length() < 3) {
            return 0;
        }

        int waviness = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char left = s.charAt(i - 1);
            char curr = s.charAt(i);
            char right = s.charAt(i + 1);

            if ((curr > left && curr > right) ||
                (curr < left && curr < right)) {
                waviness++;
            }
        }

        return waviness;
    }
}