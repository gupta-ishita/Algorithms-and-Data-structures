public class MirrorTree {
    
    public boolean mirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) && mirrorTree(p.left, q.right) && mirrorTree(p.right, q.left);
    }

    public static void main(String X[]) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(1);

        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(1);
        B.right = new TreeNode(2);

        MirrorTree obj = new MirrorTree();
        System.out.println(obj.mirrorTree(A,B));
    }
}
