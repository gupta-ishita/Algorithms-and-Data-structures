import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());
            
            int queue_length = queue.size();
            for (int i=0; i<queue_length; i++) {
                TreeNode curr = queue.remove();
                levels.get(level).add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            level++;
        }        
        return levels;
    }

    public static void main(String X[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
 
        LevelOrder obj = new LevelOrder();
        List<List<Integer>> res = obj.levelOrder(root);

        for (List<Integer> list: res){
            for(int num: list)
               System.out.print(num + " ");
            System.out.println();
        }
        
    }
}
