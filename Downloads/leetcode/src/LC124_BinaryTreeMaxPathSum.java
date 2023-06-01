public class LC124_BinaryTreeMaxPathSum {

    public static void main(String[] args) {
        // Create your binary tree
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calculate the maximum path sum
        LC124_BinaryTreeMaxPathSum m = new LC124_BinaryTreeMaxPathSum();
        int maxSum = m.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxSum);
    }

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        l = Math.max(0, l);
        r = Math.max(0, r);

        // maintain the global max value
        res = Math.max(res, l + r + node.val);

        return Math.max(l, r) + node.val; // single side
    }
}
