import java.util.*

/* 
   Check whether a valid path exists from source to destination
   Input is given in array format where edges[i] = [ui, vi] denotes 
   a bi-directional edge between vertex ui and vertex vi 
   Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
   Output: true
*/
class CheckIfPathExists {
    public boolean validPath_DFS(int[][] edges, int source, int destination) {
        // Form an adjacency matrix
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges){
            int a = edge[0]; int b = edge[1];
            // Storing for both as it is a bidirectional edge
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        // Mark as visited then insert in stack
        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);

        while(!stack.isEmpty()) {
            int currNode = stack.pop();
            if (currNode == destination)
                return true;
            for(int nextNode: graph.get(currNode)) {
                if (!visited[nextNode]){
                    visited[nextNode] = true;
                    stack.push(nextNode);
                }
            }
        }
        return false;     
    }

    public boolean validPath_BFS(int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges) {
            int a = edge[0]; int b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        // Mark as visited then insert into queue
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()) {
            int currNode = queue.remove();
            if (currNode == destination) return true;
            for (int nextNode: graph.get(currNode)) {
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
        return false;
    }
    public static void main(String[] X){
        CheckIfPathExists obj = new CheckIfPathExists();
        int[][] edge = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        boolean res_BFS = obj.validPath_BFS(edge, 1, 5);
        boolean res_DFS = obj.validPath_DFS(edge, 1, 5);
        System.out.println(res_BFS + " " + res_DFS);
    }
}