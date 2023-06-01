public class LC100_SameTree {

    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        test(tree1, tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        test(tree2, tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        TreeNode tree5 = new TreeNode(1);
        tree5.left = new TreeNode(2);
        tree5.right = new TreeNode(3);
        test(tree3, tree5, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(1);
        TreeNode tree6 = new TreeNode(1);
        tree6.left = new TreeNode(1);
        tree6.right = new TreeNode(2);


        test(tree4, tree6, "Test Case 4");
    }

    private static void test(TreeNode root1, TreeNode root2, String testCase) {
        LC100_SameTree solution = new LC100_SameTree();
        boolean result = solution.isSameTree(root1, root2);
        System.out.println(testCase + ": " + result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
