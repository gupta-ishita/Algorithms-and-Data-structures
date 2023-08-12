/*
 * Find the number of islands in a given matrix.
 * Island '1' is surrounded by water '0'
 */

public class NumberOfIslands {
    int[] rowX = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colY = {-1, 0, 1, -1, 1, -1, 0, 1};
    public int countIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, char[][] grid) {
        // Mark as visited
        grid[row][col] = '0';

        // Navigate each neighbour and call dfs to cover the depth
        for(int i=0; i<8; i++) {
            int newRow = row + rowX[i];
            int newCol = col + colY[i];
            if (newRow >= 0 && newRow < grid.length && newCol >=0 
            && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                dfs(newRow, newCol, grid);
            }
        }
    }

    public static void main(String[] X) { 
        NumberOfIslands obj = new NumberOfIslands();
        char[][] grid = {{'0','1','1','0'}, {'0','1','1','0'}, {'0','0','1','0'},{'0','0','0','0'},{'1','1','0','1'}};
        int answer = obj.countIslands(grid);
        System.out.println(answer);
    }
}

/*
 * Basically find the connected components
 * 
 */
