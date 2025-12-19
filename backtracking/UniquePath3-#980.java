/**
 * Problem: Unique Paths III
 * Platform: LeetCode
 *
 * Approach (Backtracking):
 * 1. Find the starting position (1) and mark it as visited (1).
 * 2. Recursively explore all possible paths from the starting position.
 * 3. If the current position is the end position (2), check if all cells have been visited.
 * 4. If all cells have been visited, increment the result.
 * 5. Return the result.
 * 
 * Time Complexity: O(4^(m*n))
 * Space Complexity: O(m*n)
 * 
 * Explanation:
 * 1. We use a backtracking approach to explore all possible paths from the starting position.
 * 2. We use a visited array to keep track of the cells that have been visited.
 * 3. We use a result variable to keep track of the number of unique paths.
 * 4. We use a backtrack function to explore all possible paths from the current position.
 * 5. We use a isFullVisited function to check if all cells have been visited.
 * 6. We return the result.
 * 
 * 
 */

class Solution {
    private int result = 0;
    // the reason we create a result variable outside the main function is because result were local, it would be lost when recursion unwinds
    public int uniquePathsIII(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int startRow = 0;
        int startCol = 0;
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length;c++){
                if(grid[r][c]==1){
                    startRow = r;
                    startCol = c;
                }else if(grid[r][c]==-1) visited[r][c] = -1;
            }
        }
        visited[startRow][startCol] = 1;
        backTrack(grid,visited,startRow+1, startCol);
        backTrack(grid,visited,startRow-1, startCol);
        backTrack(grid,visited,startRow, startCol+1);
        backTrack(grid,visited,startRow, startCol-1);

        return result;
        
    }
    public void backTrack(int[][] grid,int [][] visited, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || visited[r][c]==1 || visited[r][c]==-1) return;
        visited[r][c] = 1;
        if(grid[r][c]==2){
            if(isFullVisited(visited)) result++;
            visited[r][c] = 0;
            return;
        }
        backTrack(grid,visited,r+1,c);
        backTrack(grid,visited,r-1,c);
        backTrack(grid,visited,r,c+1);
        backTrack(grid,visited,r,c-1);
        visited[r][c] = 0;
    }
    public boolean isFullVisited(int[][] grid){
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length;c++){
                if(grid[r][c]==0){
                    return false;
                }
            }
        }
        return true;
    }
}