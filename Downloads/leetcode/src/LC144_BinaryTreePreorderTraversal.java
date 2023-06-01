

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class LC144_BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        testPreorderTraversal(tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        testPreorderTraversal(tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        tree3.left.left = new TreeNode(4);
        tree3.left.right = new TreeNode(5);
        testPreorderTraversal(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(1);
        tree4.left = null;
        tree4.right = new TreeNode(2);
        tree4.right.left = new TreeNode(3);

        testPreorderTraversal(tree4, "Test Case 4");
    }

    private static void testPreorderTraversal(TreeNode root, String testCase) {
        LC144_BinaryTreePreorderTraversal solution = new LC144_BinaryTreePreorderTraversal();
        List<Integer> result = solution.preorderTraversal(root);
        System.out.println(testCase + ": " + Arrays.toString(result.toArray()));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}



