/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

/**
 * Problem: Implement Rand10() Using Rand7()
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a math approach to generate a random integer in the range 1 to 10 using the rand7() API.
 * 2. Use a loop to generate a random integer in the range 1 to 10 using the rand7() API.
 * 3. Return the random integer in the range 1 to 10.
 */
/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int row = rand7();
            int col = rand7();
            int num = (row - 1) * 7 + col; 
            if (num <= 40) {
                return (num - 1) % 10 + 1;
            }
        }
    }
}