package leetsCode.easy;

public class MaximumDepthOfBinaryTreeSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
            TreeNode l = new TreeNode(9);
            TreeNode r = new TreeNode(20);
            root.left = l;
            root.right = r;

            TreeNode rl = new TreeNode(15);
            TreeNode rr = new TreeNode(7);
            r.left = rl;
            r.right = rr;

        System.out.println(maxDepth(root));

    }
    public static int maxDepth(TreeNode root) {
        return visit(root, 0);
    }

    private static int visit(TreeNode root, int count) {
        if (root == null)
            return count;
        return Math.max(visit(root.left, count + 1), visit(root.right, count + 1));
    }
}
