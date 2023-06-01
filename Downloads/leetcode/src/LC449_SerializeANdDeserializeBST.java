import java.util.LinkedList;
import java.util.Queue;

public class LC449_SerializeANdDeserializeBST {
    public static void main(String[] args) {
        // Test case: Create a binary search tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        LC449_SerializeANdDeserializeBST m = new LC449_SerializeANdDeserializeBST();

        // Serialize the binary search tree
        String serialized = m.serialize(root);
        System.out.println("Serialized BST: " + serialized);

        // Deserialize the binary search tree
        TreeNode deserialized = m.deserialize(serialized);

        // Print the deserialized tree
        m.printTree(deserialized);
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print("null ");
            } else {
                System.out.print(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.println();
    }

    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] strs = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String s : strs) {
            if (!s.equals("#")) queue.offer(Integer.parseInt(s));
        }
        return dfs(queue);
    }

    private TreeNode dfs(Queue<Integer> queue) {
        // base case
        if (queue.isEmpty()) return null;

        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> sq = new LinkedList<>();
        while (!queue.isEmpty()) {
            if (queue.peek() < root.val) sq.offer(queue.poll());
            else break;
        }
        root.left = dfs(sq);
        root.right = dfs(queue);
        return root;

    }
}