/*
 * Implement the BFS Traversal in a directed graph
 * 
 * Input : Array of edges has been provided
 */

import java.util.*;

public class BFSTraversal {
    
    public void bfs(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) { 
            int from = edge[0]; int to = edge[1];
            adjList.get(from).add(to);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
/*
 *   Mark the element as visited as soon as it has been entered into the queue
 *   signifying that it has been touched
 */
        boolean[] visited = new boolean[n];
        
        // Add source in the queue and mark it as visited
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int curr = queue.remove();
            System.out.print(curr + " ");

            // Insert all the non-visited neighbours into the queue 
            for (int next : adjList.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String X[]){
        BFSTraversal obj = new BFSTraversal();
        int[][] edges = {{0,1}, {0,3}, {0,4}, {1,4}, {1,2}, {2,3}, {3,4}};
        obj.bfs(edges, 5);
    }
}


/*
 * BFS is implemented with the help of queue data structure
 */