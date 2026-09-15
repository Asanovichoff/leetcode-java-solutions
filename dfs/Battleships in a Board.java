/**
 * 419. Battleships in a Board
 * 
 * approach: DFS
 * 1. We can solve this problem using a depth-first search (DFS) approach.
 * 2. We will maintain a reference to the input board and define a recursive function `dfs(r, c)` that marks the battleship at position `(r, c)` and its adjacent cells as visited.
 * 3. In each call to `dfs`, we will check if the current cell is valid (i.e., within the bounds of the board and not already visited) and mark it as visited by changing its value to '.'.
 * 4. We will then recursively call `dfs` for the adjacent cells (up, down, left, right) to mark the entire battleship as visited.
 * 5. Finally, we will return the count of battleships found in the board.
 * time complexity: O(m*n), where m is the number of rows and n is the number of columns in the input board, as we may need to visit each cell in the board during the DFS traversal.
 * space complexity: O(m*n), where m is the number of rows and n is the number of columns in the input board, which is the space required for the recursion stack during the DFS traversal.
 */
class Solution {
    private char[][] board;
    public int countBattleships(char[][] board) {
        this.board = board;
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs (i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs (int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '.') return;
        board[r][c] = '.';
        dfs (r+1, c);
        dfs (r-1, c);
        dfs (r, c+1);
        dfs (r, c-1);
    }
}