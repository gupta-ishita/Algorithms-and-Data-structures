public class MaxDepth {
    int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right) + 1);
    }

    public static void main(String X[]){
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        
        MaxDepth obj = new MaxDepth();
        
        System.out.println(obj.maxDepth(root1));
        System.out.println(obj.maxDepth(root2));
    }
}
