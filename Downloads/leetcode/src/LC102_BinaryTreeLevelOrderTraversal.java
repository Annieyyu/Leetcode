import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        test(tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        test(tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(3);
        tree3.left = new TreeNode(9);
        tree3.right = new TreeNode(20);
        tree3.right.left = new TreeNode(15);
        tree3.right.right = new TreeNode(7);
        test(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(3);
        tree4.right = new TreeNode(2);

        test(tree4, "Test Case 4");
    }

    private static void test(TreeNode root, String testCase) {
        LC102_BinaryTreeLevelOrderTraversal solution = new LC102_BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(testCase + ": " + Arrays.toString(result.toArray()));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }

        return res;
    }

}
