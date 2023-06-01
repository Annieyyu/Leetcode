import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LC145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        testPostorderTraversal(tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        testPostorderTraversal(tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        tree3.left.left = new TreeNode(4);
        tree3.left.right = new TreeNode(5);
        testPostorderTraversal(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(1);
        tree4.left = null;
        tree4.right = new TreeNode(2);
        tree4.right.left = new TreeNode(3);

        testPostorderTraversal(tree4, "Test Case 4");
    }

    private static void testPostorderTraversal(TreeNode root, String testCase) {
        LC145_BinaryTreePostorderTraversal solution = new LC145_BinaryTreePostorderTraversal();
        List<Integer> result = solution.postorderTraversal(root);
        System.out.println(testCase + ": " + Arrays.toString(result.toArray()));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
    }

}



