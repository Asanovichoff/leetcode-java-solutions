class Solution {
    char[][] grid;
    int m, n;
    boolean[][][] seen;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 == 1 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        seen = new boolean[m][n][m + n];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int r, int c, int bal) {
        if (r >= m || c >= n) return false;
        bal += grid[r][c] == '(' ? 1 : -1;
        if (bal < 0 || bal > (m - 1 - r) + (n - 1 - c)) return false;
        if (r == m - 1 && c == n - 1) return bal == 0;
        if (seen[r][c][bal]) return false;
        seen[r][c][bal] = true;
        return dfs(r + 1, c, bal) || dfs(r, c + 1, bal);
    }
}
