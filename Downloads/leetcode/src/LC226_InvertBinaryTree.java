import java.util.LinkedList;
import java.util.Queue;

public class LC226_InvertBinaryTree {

    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;
        test(tree1, "Test Case 1");

        // Test Case 2: Tree with a single node
        TreeNode tree2 = new TreeNode(1);
        test(tree2, "Test Case 2");

        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(4);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(7);
        tree3.left.left = new TreeNode(1);
        tree3.left.right = new TreeNode(3);
        tree3.right.left = new TreeNode(6);
        tree3.right.right = new TreeNode(9);
        test(tree3, "Test Case 3");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(3);
        test(tree4, "Test Case 4");
    }

    private static void test(TreeNode root, String testCase) {
        LC226_InvertBinaryTree solution = new LC226_InvertBinaryTree();
        System.out.print(testCase + ": ");
        printTree(root);
        TreeNode result = solution.invertTree(root);
        System.out.print("Inverted Tree: ");
        printTree(result);
        System.out.println();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        dfs(cur.left);
        dfs(cur.right);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        System.out.println();
    }
}
