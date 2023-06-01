
public class LC572_BinaryTreeSubtree {

    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        test(tree1, tree1, "Test Case 1");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(3);
        tree3.left = new TreeNode(4);
        tree3.right = new TreeNode(5);
        tree3.left.left = new TreeNode(1);
        tree3.left.right = new TreeNode(2);
        tree3.left.right.left = new TreeNode(0);
        TreeNode tree5 = new TreeNode(4);
        tree5.left = new TreeNode(1);
        tree5.right = new TreeNode(2);
        test(tree3, tree5, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(3);
        tree4.left = new TreeNode(4);
        tree4.right = new TreeNode(5);
        tree4.left.left = new TreeNode(1);
        tree4.left.right = new TreeNode(2);
        TreeNode tree6 = new TreeNode(4);
        tree6.left = new TreeNode(1);
        tree6.right = new TreeNode(2);

        test(tree4, tree6, "Test Case 4");
    }

    private static void test(TreeNode root1, TreeNode root2, String testCase) {
        LC572_BinaryTreeSubtree solution = new LC572_BinaryTreeSubtree();
        boolean result = solution.isSubtree(root1, root2);
        System.out.println(testCase + ": " + result);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}
