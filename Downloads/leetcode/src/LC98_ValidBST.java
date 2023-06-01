public class LC98_ValidBST {

    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        test(tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        test(tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(2);
        tree3.left = new TreeNode(1);
        tree3.right = new TreeNode(3);
        test(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(5);
        tree4.left = new TreeNode(1);
        tree4.right = new TreeNode(4);
        tree4.right.left = new TreeNode(3);
        tree4.right.right = new TreeNode(6);

        test(tree4, "Test Case 4");
    }

    private static void test(TreeNode root, String testCase) {
        LC98_ValidBST solution = new LC98_ValidBST();
        boolean result = solution.isValidBST(root);
        System.out.println(testCase + ": " + result);
    }
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return dfs(root);
    }

    private TreeNode prev;

    private boolean dfs(TreeNode cur) {
        if (cur == null) {
            return true;
        }
        if (!dfs(cur.left)) {
            return false;
        }

        if (prev != null && prev.val >= cur.val) {
            return false;
        }

        prev = cur;

        return dfs(cur.right);
    }
}
