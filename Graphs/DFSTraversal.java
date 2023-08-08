/*
 * Implement DFS Traversal of a directed graph. 
 * Input : matrix of edges has been provided
 */
import java.util.*;

public class DFSTraversal {
    /*
     * DFS implicitly uses Stack data structure
     */
    public void dfs(int curr, boolean[] visited, List<List<Integer>> graph) {
        // Mark the current node as visited
        visited[curr] = true;
        System.out.print (curr + " ");

        // Loop through each neighbour and call DFS to cover the depth of that path
        for (int next: graph.get(curr)){
            if (!visited[next]) {
                dfs(next, visited,graph);                
            }
        }
    }

    public void graphTraversal(int[][] edges, int n){
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int from = edge[0]; int to = edge[1];
            adjList.get(from).add(to);
        }
        boolean[] visited = new boolean[n];
        dfs(0, visited, adjList);
    }

    public static void main(String X[]){
        DFSTraversal obj = new DFSTraversal();
        int[][] edges = {{0,1}, {0,3}, {0,4}, {1,4}, {1,2}, {2,3}, {3,4}};
        obj.graphTraversal(edges, 5);
    }
}
