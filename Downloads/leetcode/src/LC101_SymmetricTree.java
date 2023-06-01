public class LC101_SymmetricTree {

    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        test(tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        test(tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(2);
        tree3.left.left = null;
        tree3.left.right = new TreeNode(3);
        tree3.right.left = null;
        tree3.right.right= new TreeNode(3);
        test(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(2);
        tree4.right.left = new TreeNode(4);
        tree4.right.right = new TreeNode(3);
        tree4.left.right = new TreeNode(4);
        tree4.left.left = new TreeNode(3);

        test(tree4, "Test Case 4");
    }

    private static void test(TreeNode root, String testCase) {
        LC101_SymmetricTree solution = new LC101_SymmetricTree();
        boolean result = solution.isSymmetric(root);
        System.out.println(testCase + ": " + result);
    }



    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left ,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
