/**
 * Problem: Rectangle Area
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a math approach to calculate the area of the two rectangles.
 * 2. Use a loop to iterate through the rectangles and calculate the area of the two rectangles.
 * 3. Return the area of the two rectangles.
 */
/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a math approach to calculate the area of the two rectangles.
 * 2. We use a loop to iterate through the rectangles and calculate the area of the two rectangles.
 * 3. We return the area of the two rectangles.
 */
class Solution {
    private int aria1;
    private int aria2;
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        aria1 = (ax2-ax1) * (ay2-ay1);
        aria2 = (bx2-bx1) * (by2-by1);
        int aria = aria1+aria2;

        int x1 = Math.min(ax2, bx2);
        int x2 = Math.max(ax1, bx1);
        int x = x1-x2;
        if (x<0) x = 0;
        
        int y1 = Math.min(ay2, by2);
        int y2 = Math.max(ay1, by1);
        int y = y1-y2;
        if (y<0) y = 0;

        int intersect = x*y;
        return aria-intersect;

    }
}    
