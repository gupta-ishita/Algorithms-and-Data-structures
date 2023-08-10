/*
 * Count the number of provinces : connected components form a single province
 * Input is provided as an adjacency matrix
 */
public class NoOfProvinces {

    public int countComponents(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    public void dfs(int curr, int[][] isConnected, boolean[] visited) {
        // Mark the current node as visited
        visited[curr] = true;

        // Loop through list of neighbours and call dfs for each unvisited neighbour
        for (int next=0; next<isConnected.length; next++){
            if (isConnected[curr][next] == 1 && !visited[next]) {
                dfs(next, isConnected, visited);
            }
        }
    }

    public static void main(String[] X) { 
        NoOfProvinces obj = new NoOfProvinces();
        int[][] graph = {{0,0,0,1,0,0}, {0,0,1,0,0,0}, {0,1,0,0,1,0},{1,0,0,0,0,0},{0,0,1,0,0,0},{0,0,0,0,0,0}};
        int answer = obj.countComponents(graph);
        System.out.println(answer);
    }
}

// Can be implemented through DFS also