/**
 * Problem: N-th Tribonacci Number
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a loop to iterate through the array and calculate the number of ways to reach the current step.
 * 2. Return the number of ways to reach the last step.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a loop to iterate through the array and calculate the number of ways to reach the current step.
 * 2. We return the number of ways to reach the last step.
 * 
 * 
 * 
 */ 
class Solution {
    public int tribonacci(int n) {
        // n = n-1+n-2+n-3   
        if(n==0) return 0;
        if(n<3) return 1;//edge cases
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        int num  = 0;
        for(int i = 3; i<=n;i++){
            num = (n2+n1+n0);
            n0 = n1;
            n1 = n2;
            n2 = num;
        } 
        return num;
    }
}
