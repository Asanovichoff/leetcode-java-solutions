/**
 * Problem: Pascal's Triangle
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a recursive approach to calculate the Pascal's Triangle.
 * 2. Use a loop to iterate through the array and calculate the Pascal's Triangle.
 * 3. Return the Pascal's Triangle.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * 
 * Explanation:
 * 1. We use a recursive approach to calculate the Pascal's Triangle.
 * 2. We use a loop to iterate through the array and calculate the Pascal's Triangle.
 * 3. We return the Pascal's Triangle.
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        if(numRows<1) return result;
        prevRow.add(1);
        result.add(prevRow);
        while(result.size()<numRows){
            List<Integer>row = new ArrayList<>();
            prevRow = result.get(result.size()-1);
            int cur = -1; int next=0;
            while(cur<prevRow.size()){
                if(cur==-1){
                    row.add(prevRow.get(next));
                }else if(next == prevRow.size()){
                    row.add(prevRow.get(cur));
                }else{
                    row.add(prevRow.get(next)+prevRow.get(cur));
                }
                cur++;
                next++;
            }
            result.add(row);            
        }
        return result;
    }
}