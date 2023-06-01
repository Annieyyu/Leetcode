
public class LC114_FlattenBTToLinkedlist {

    public static void main(String[] args) {
        // Test case: Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        LC114_FlattenBTToLinkedlist m = new LC114_FlattenBTToLinkedlist();
        m.flatten(root);

        // Print the flattened tree
        m.printLinkedList(root);
    }

    private void printLinkedList(TreeNode node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(node.val + " ");
        printLinkedList(node.left);
        printLinkedList(node.right);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
