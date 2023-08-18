/*
 *    Find all paths from source (0,0) to destination (m-1, n-1)
 */

import java.util.*;

public class AllPaths {
    static List<List<Integer>> paths;
    public static List<List<Integer>> allPathsSourceTarget_DFS(int[][] graph) {
        paths = new ArrayList<>();
        int destination = graph.length - 1;
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        backtrack(0, destination, graph, path);
        return paths;
    }

    private static void backtrack (int currNode, int destination, int[][] graph, LinkedList<Integer> path) {
        if (currNode == destination) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }

        
        for(int nextNode: graph[currNode]) {
            path.addLast(nextNode);
            backtrack(nextNode, destination, graph, path);
            path.removeLast();
        }

    }

    public static void main(String[] X) {
        int[][] graph = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        List<List<Integer>> res_DFS = allPathsSourceTarget_DFS(graph);
        for(List<Integer> tr : paths){
            for(int ele: tr)
               System.out.print(ele + " ");
            System.out.println();
        }
    }
}
