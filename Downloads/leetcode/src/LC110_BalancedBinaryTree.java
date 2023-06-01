public class LC110_BalancedBinaryTree {
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
        tree3.left.left = new TreeNode(3);
        tree3.left.right = new TreeNode(3);
        tree3.left.left.left = new TreeNode(4);
        tree3.left.left.right = new TreeNode(4);
        test(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(3);
        tree4.left = new TreeNode(9);
        tree4.right = new TreeNode(20);
        tree4.right.left = new TreeNode(15);
        tree4.right.right = new TreeNode(7);

        test(tree4, "Test Case 4");
    }

    private static void test(TreeNode root, String testCase) {
        LC110_BalancedBinaryTree solution = new LC110_BalancedBinaryTree();
        boolean result = solution.isBalanced(root);
        System.out.println(testCase + ": " + result);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return DFS(root);
    }

    private boolean DFS(TreeNode cur) {
        if (cur == null) {
            return true;
        }
        int left = maxDepth(cur.left);
        int right = maxDepth(cur.right);

        return Math.abs(left - right) <= 1 && DFS (cur.left) && DFS(cur.right)  ;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
