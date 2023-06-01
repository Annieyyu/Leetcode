public class LC270_ClosestBST {

    public static void main(String[] args) {
        // Test Case 1: Empty tree
        TreeNode tree1 = null;


        // Test Case 3: Tree with multiple nodes
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        double target2 = 4.428571;
        test(tree3, target2 ,"Test Case 2");

        // Add more test cases as needed
        TreeNode tree4 = new TreeNode(4);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(5);
        tree4.left.left = new TreeNode(1);
        tree4.left.right = new TreeNode(3);
        double target1 = 3.714286;
        test(tree4, target1, "Test Case 4");
    }

    private static void test(TreeNode root, double target, String testCase) {
        LC270_ClosestBST solution = new LC270_ClosestBST();
        int result = solution.closestValue(root,target);
        System.out.println(testCase + ": " + result);
    }
    public int closestValue(TreeNode root, double target) {
        //if(root == null) throw new NullPointerException();
        int min = root.val;
        TreeNode curr = root;
        while(curr!= null){
            if(Math.abs(curr.val-target)<=Math.abs(min-target)){
                min = curr.val;
            }
            if(curr.val<target){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return min;


    }
}
