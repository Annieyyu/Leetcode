import java.util.ArrayList;
import java.util.List;

public class LC113_PathSumII {

    public static void main(String[] args) {
        // Create your binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Set the target sum
        int targetSum = 22;

        // Find the paths
        LC113_PathSumII m = new LC113_PathSumII();
        List<List<Integer>> paths = m.pathSum(root, targetSum);

        // Print the paths
        System.out.println("Paths that sum up to " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, 0, path, res);
        return res;
    }

    private void dfs(TreeNode cur, int targetSum, int pathSum, List<Integer> path, List<List<Integer>> res) {
        if (cur == null) {
            return;
        }
        pathSum += cur.val;
        path.add(cur.val);
        if (cur.left == null && cur.right == null && pathSum == targetSum) {
            res.add(new ArrayList<>(path));
        }
        dfs(cur.left, targetSum, pathSum, path, res);
        dfs(cur.right, targetSum, pathSum, path, res);
        path.remove(path.size() - 1);
    }

}
