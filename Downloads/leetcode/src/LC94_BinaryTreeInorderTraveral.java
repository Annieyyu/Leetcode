
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class LC94_BinaryTreeInorderTraveral {
    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        testInorderTraversal(tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        testInorderTraversal(tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        tree3.left.left = new TreeNode(4);
        tree3.left.right = new TreeNode(5);
        testInorderTraversal(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(1);
        tree4.left = null;
        tree4.right = new TreeNode(2);
        tree4.right.left = new TreeNode(3);

        testInorderTraversal(tree4, "Test Case 4");
    }

    private static void testInorderTraversal(TreeNode root, String testCase) {
        LC94_BinaryTreeInorderTraveral solution = new LC94_BinaryTreeInorderTraveral();
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(testCase + ": " + Arrays.toString(result.toArray()));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }

}



