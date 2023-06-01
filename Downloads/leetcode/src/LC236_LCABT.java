public class LC236_LCABT {

    public static void main(String[] args) {
        // Create your binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Define the nodes for which you want to find the LCA
        TreeNode p = root.left;  // Node with value 5
        TreeNode q = root.right; // Node with value 1

        // Find the lowest common ancestor
        LC236_LCABT m = new LC236_LCABT();
        TreeNode lca = m.lowestCommonAncestor(root, p, q);

        // Print the value of the lowest common ancestor
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;

    }
}
