public class SameTree {

    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;

        return (p.val == q.val) && sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    public static void main(String X[]) {

        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(1);

        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(1);
        B.right = new TreeNode(2);

        SameTree obj = new SameTree();
        System.out.println(obj.sameTree(A,B));
    }
    
}
