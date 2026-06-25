/**
 * Problem: Maximum Building Height
 * Platform: LeetCode
 *
 * Approach (Math):
 * 1. Use a math approach to calculate the maximum building height.
 * 2. Use a loop to iterate through the buildings and calculate the maximum building height.
 * 3. Return the maximum building height.
 */
/**
 * Time Complexity: O(m log m)
 * Space Complexity: O(m)
 * 
 * Explanation:
 * 1. We use a math approach to calculate the maximum building height.
 * 2. We use a loop to iterate through the buildings and calculate the maximum building height.
 * 3. We return the maximum building height.
 */
class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] buildings = new int[m+2][2];
        for (int i = 0; i < m; i++) buildings[i] = restrictions[i];
        buildings[m] = new int[]{1,0};
        buildings[m+1] = new int[]{n, n-1};
        Arrays.sort(buildings, (a,b) -> Integer.compare(a[0],b[0]));
        m+=2;
        for (int i = 1; i < m; i++) {
            int dist = buildings[i][0] - buildings[i-1][0];
            buildings[i][1] = Math.min(buildings[i][1], dist + buildings[i-1][1]);
        }
        for (int i = m-2; i >= 0; i--) {
            int dist = buildings[i+1][0] - buildings[i][0];
            buildings[i][1] = Math.min(buildings[i][1], dist + buildings[i+1][1]);
        }
        int res = 0;
        for (int i = 0; i < m-1; i++) {
            int dist = buildings[i+1][0] - buildings[i][0];
            int best = (dist + buildings[i][1] + buildings[i+1][1]) / 2;
            res = Math.max(res, best);
        }
        return res;

    }
}
