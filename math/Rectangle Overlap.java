/**
 * 836. Rectangle Overlap
 * Given two rectangles, return whether they overlap.
 * 
 *approach:
 * 1. We can solve this problem by checking the coordinates of the two rectangles.
 * 2. We will check if the rectangles are valid (i.e., they have non-zero area) and if they do not overlap by comparing their coordinates.
 * 3. If the rectangles are valid and do not overlap, we will return false. Otherwise, we will return true. 
 * time complexity: O(1), as we are performing a constant number of comparisons to check the coordinates of the rectangles.
 * space complexity: O(1), as we are not using any additional data structures that scale with the input size.
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec2[0] == rec2[2] || rec1[1] == rec1[3] || rec2[1] == rec2[3]) return false;
        if (rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[2] <= rec2[0] || rec1[3] <= rec2[1]) return false;
        return true;
    }
}