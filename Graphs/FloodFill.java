/*
 * Implement Flood Fill Algorithm starting from (sr, sc) with a given color val.
 * Only the cells having initial color at image[sr][sc] should be replaced
 * 
 */
public class FloodFill {
    int[] rows = {-1, 0, 0, 1};
    int[] cols = {0, -1, 1, 0};
    public int[][] floodFillAlgo(int[][] image, int sr, int sc, int val) {
        dfs(image, sr, sc, val, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int val, int initial) {
        // Mark each node as visited
        image[row][col] = val;

        // Visit each neighbour and call dfs to cover the depth 
        for(int i=0; i<4; i++) {
            int newRow = row + rows[i];
            int newCol = col + cols[i];
            if (newRow >= 0 && newRow < image.length && newCol >= 0 
            && newCol < image[0].length && image[newRow][newCol] == initial) {
                dfs(image, newRow, newCol, val, initial);
            }
        }
    }

    public void print(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] X) { 
        FloodFill obj = new FloodFill();
        int[][] grid = {{1,1,1}, {2,2,0}, {2,2,2}};
        int[][] answer = obj.floodFillAlgo(grid, 2, 0, 3);
        obj.print(answer);
    }
}
