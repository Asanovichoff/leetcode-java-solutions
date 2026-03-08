/**
 * Problem: Multiply Strings
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a math approach to multiply the two strings.
 * 2. Use a loop to iterate through the strings and multiply the two strings.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n*m)
 * Space Complexity: O(n+m)
 * 
 * Explanation:
 * 1. We use a math approach to multiply the two strings.
 * 2. We use a loop to iterate through the strings and multiply the two strings.
 * 3. We return the result.
 */
class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i>=0; i--){
            for (int j = num2.length()-1; j>=0; j--){
                int n = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                n+= result[i+j+1];
                result[i+j+1] = n%10;
                result[i+j] +=n/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}