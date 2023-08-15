import java.util.*;

/*
   You are given an m x n grid where each cell can have one of three values:
    0 representing empty cell,
    1 representing a fresh orange,
    2 representing a rotten orange    
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
    Return the minimum number of minutes to make all fresh oranges to rotten. If this is impossible, return -1.

    Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4

    Basically minimum number of steps to cover all fresh nodes
 */

 public class RottenOranges {
    public int orangesRotting_BFS(int[][] grid) {
        
        int ROW = grid.length;
        int COL = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int timestamp = -1;
        
        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COL; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i,j});
            }
        }

        while (!queue.isEmpty()) {
            timestamp++;
            for (int i=0; i<queue.size(); i++) {
                int[] currNode = queue.remove();
                int curr_Row = currNode[0]; int curr_Col = currNode[1];
                 
                // Add each neighbour to the queue, after marking them as visited
                int[] row_X = {-1, 0 ,0, 1}; int[] col_Y = {0, -1, 1, 0};
                
                for (int j=0; j<4; j++) {
                    int newRow = curr_Row + row_X[j]; int newCol = curr_Col + col_Y[j];
                    if (newRow >= 0 && newCol >= 0 && newRow < ROW && newCol < COL) {
                        if (grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2; 
                            queue.add(new int[]{newRow, newCol});
                        }
                    } 
                }
            }
        }

        return timestamp;
    }

    public static void main(String[] X){
        RottenOranges obj = new RottenOranges();
        int[][] edge = {{2,1,1}, {1,1,0}, {0,1,2}};
        int res_BFS = obj.orangesRotting_BFS(edge);
        System.out.println(res_BFS);
    }
}

/*
 * Since neighbouring nodes are to be covered simultenously, we take BFS into consideration
 */