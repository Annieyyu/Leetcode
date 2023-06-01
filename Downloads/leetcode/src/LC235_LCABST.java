public class LC235_LCABST {

    public static void main(String[] args) {
        // Create your binary search tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Define the nodes for which you want to find the LCA
        TreeNode p = root.left;  // Node with value 2
        TreeNode q = root.right; // Node with value 8

        // Find the lowest common ancestor
        LC235_LCABST m = new LC235_LCABST();
        TreeNode lca = m.lowestCommonAncestor(root, p, q);

        // Print the value of the lowest common ancestor
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
