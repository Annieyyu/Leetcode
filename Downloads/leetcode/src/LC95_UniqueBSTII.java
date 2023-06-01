import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC95_UniqueBSTII {

    public static void main(String[] args) {
        LC95_UniqueBSTII m = new LC95_UniqueBSTII();
        int n = 3;

        // Generate all unique BSTs
        List<TreeNode> uniqueBSTs = m.generateTrees(n);

        // Print all unique BSTs
        for (TreeNode root : uniqueBSTs) {
            m.printTree(root);
            System.out.println();
        }
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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    private List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int k = start; k <= end; k++){
            List<TreeNode> lefts = dfs(start, k - 1);
            List<TreeNode> rights = dfs(k + 1, end);
            for(TreeNode l : lefts){
                for(TreeNode r : rights){
                    TreeNode root = new TreeNode(k);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
