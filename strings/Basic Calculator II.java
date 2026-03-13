/**
 * Problem: Basic Calculator II
 * Platform: LeetCode
 *
 * Approach (Stack):
 * 1. Use a stack to store the numbers and operators.
 * 2. Use a loop to iterate through the string and calculate the result.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)    

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a stack to store the numbers and operators.
 * 2. We use a loop to iterate through the string and calculate the result.
 * 3. We return the result.
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (char c: s.toCharArray()){
            if(c!='-' && c!='+' && c!='*' && c!='/' && c!=' '){
                num = (10*num)+(c-'0');
            }else{
                if (c== ' ') continue;
                if (sign == '-'){
                    num*=-1;
                }else if (sign == '/'){
                    num = stack.pop()/num;
                }else if (sign == '*'){
                    num = stack.pop()*num;
                }
                sign = c;
                stack.push(num);
                num = 0;
            }
        }
        if (sign == '-'){
            num*=-1;
        }else if (sign == '/'){
            num = stack.pop()/num;
        }else if (sign == '*'){
            num = stack.pop()*num;
        }
        stack.push(num);
        num = 0;

        while (!stack.isEmpty()){
            num +=stack.pop();
        }
        return num;
    }
}