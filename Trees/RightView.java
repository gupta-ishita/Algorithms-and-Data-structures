import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {

    public List<Integer> rightView(TreeNode root) {
        List<Integer> rightV = new ArrayList<Integer>();
        if (root == null) return rightV;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int queue_length = queue.size();
            for(int i=0; i<queue_length; i++){
                TreeNode currNode = queue.remove();
                if (i == queue_length-1) {
                    rightV.add(currNode.val);
                }

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }

        return rightV;
    }

        public static void main(String X[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
 
        RightView obj = new RightView();
        List<Integer> res = obj.rightView(root);
    
        for(int num: res)
            System.out.print(num + " ");
        
    }
    
}
