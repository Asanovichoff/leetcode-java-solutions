/**
 * Problem: Zigzag Conversion
 * Platform: LeetCode
 *
 * Approach (Simulation):
 * 1. Build answer row-by-row
 * 2. Use cycle length 2*(numRows-1)
 * 3. Add vertical chars at i
 * 4. Add diagonal chars at i + increment - 2*r for middle rows
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int increment = 2*(numRows-1);
        for(int r = 0; r<numRows; r++){
            for(int i = r; i<s.length();i+=increment){
                sb.append(s.charAt(i));
                if(r!=0 && r!=numRows-1 && i+increment-2*r<s.length()){
                    sb.append(s.charAt(i+increment-2*r));
                }
            }
        }
        return sb.toString();
    }
}
