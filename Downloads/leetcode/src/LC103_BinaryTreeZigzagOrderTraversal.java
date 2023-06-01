import java.util.*;

public class LC103_BinaryTreeZigzagOrderTraversal {

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
        LC103_BinaryTreeZigzagOrderTraversal solution = new LC103_BinaryTreeZigzagOrderTraversal();
        List<List<Integer>> result = solution.zigZagOrder(root);
        System.out.println(testCase + ": " + Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> zigZagOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offerLast(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                if (flag == false) {
                    TreeNode node = queue.pollFirst();// offer, poll, peek
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    TreeNode node = queue.pollLast();// offer, poll, peek
                    list.add(node.val);
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }

}
