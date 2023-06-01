import java.util.LinkedList;
import java.util.Queue;

public class LC108_ConvertSortedArrayToBST {

    public static void main(String[] args) {
        // Create a sorted array
        int[] nums = {-10,-3,0,5,9};

        // Convert the sorted array to a BST
        LC108_ConvertSortedArrayToBST m = new LC108_ConvertSortedArrayToBST();
        TreeNode root = m.sortedArrayToBST(nums);

        // Print the resulting BST
        m.printBST(root);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int midIdx = left + (right - left) / 2;
        int mid = nums[midIdx];
        TreeNode root = new TreeNode(mid);
        root.left = dfs(nums, left, midIdx - 1);
        root.right = dfs(nums, midIdx + 1, right);
        return root;
    }
    private void printBST(TreeNode root) {
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
}
