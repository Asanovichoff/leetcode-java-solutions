/**
 * Problem: Surrounded Regions
 * Platform: LeetCode
 *
 * Approach (Depth-First Search):
 * 1. Use a depth-first search to mark the non-surrounding regions.
 * 2. Use a loop to iterate through the board and mark the non-surrounding regions.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * 
 * Explanation:
 * 1. We use a depth-first search to mark the non-surrounding regions.
 * 2. We use a loop to iterate through the board and mark the non-surrounding regions.
 * 3. We return the result.
 */
class Solution {
    public boolean[][] onTheEdge;
    public void solve(char[][] board) {
        onTheEdge = new boolean[board.length][board[0].length];
        // checking all boards if it has 'O';
        for (int i = 0; i<board.length; i++){
            if (board[i][0] == 'O'){
                markNonSurround(i, 0, board);
            }
            if (board[i][board[0].length-1] == 'O'){
                markNonSurround(i, board[0].length-1, board);
            }
        }
        for (int j = 1; j<board[0].length-1; j++){
            if (board[0][j] == 'O'){
                markNonSurround(0, j, board);
            }
            if (board[board.length-1][j] == 'O'){
                markNonSurround(board.length-1, j, board);
            }
        }

        // find surround
        for (int r = 1; r<board.length-1; r++){
            for (int c = 1; c<board[0].length-1; c++){
                if(board[r][c] == 'O' && !onTheEdge[r][c]){
                    unmarkSurround(r, c, board);
                }
            }
        }



    }
    public void markNonSurround(int r, int c, char[][] board){
        if (r<0 || c<0 || r >= board.length || c >= board[0].length || board[r][c] == 'X' || onTheEdge[r][c]) return;
        onTheEdge[r][c] = true;
        markNonSurround(r+1, c, board);
        markNonSurround(r-1, c, board);
        markNonSurround(r, c+1, board);
        markNonSurround(r, c-1, board);
    }
    public void unmarkSurround(int r, int c, char[][] board){
        if (r<1 || c<1 || r >= board.length-1 || c >= board[0].length-1 || board[r][c] == 'X' || onTheEdge[r][c]) return;
        board[r][c] = 'X';
        unmarkSurround(r+1, c, board);
        unmarkSurround(r-1, c, board);
        unmarkSurround(r, c+1, board);
        unmarkSurround(r, c-1, board);
    }
}
