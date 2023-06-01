import java.util.LinkedList;
import java.util.Queue;

public class LC297_DesializeAndSerializeBT {

    public static void main(String[] args) {
        // Test case: Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        LC297_DesializeAndSerializeBT m = new LC297_DesializeAndSerializeBT();

        // Serialize the binary tree
        String serialized = m.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        // Deserialize the binary tree
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
        return root.val + "," + serialize(root.left) + "," + serialize(root.right); // preorder
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : strs) queue.offer(s);
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        // base case
        String cur = queue.poll();
        if (cur.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }

}
