/**
 * Problem: Validate Stack Sequences
 * Platform: LeetCode
 *
 * Approach :
 * 1. Use a stack to simulate the push and pop operations based on the pushed and popped sequences.
 * 2. Iterate through the pushed array and push elements onto the stack.
 * 3. After each push, check if the top of the stack matches the current element in the popped array. If it does, pop the element from the stack and move to the next element in the popped array.
 * 4. Continue this process until all elements in the pushed array have been processed.
 * 5. After processing all elements in the pushed array, check if the stack is empty. If it is, return true; otherwise, return false.
 */
/**
 * Time Complexity: O(n), where n is the length of the pushed array.
 * Space Complexity: O(n), where n is the length of the pushed array, as we may need to store all elements in the stack in the worst case.
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 1, j = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        while (i < pushed.length && j < popped.length) {
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
                if (stack.isEmpty()) {
                    stack.push(pushed[i]);
                    i++;
                }
            }else {
                stack.push(pushed[i]);
                i++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != popped[j]) return false;
            stack.pop();
            j++;
        }
        return true;
    }
}
