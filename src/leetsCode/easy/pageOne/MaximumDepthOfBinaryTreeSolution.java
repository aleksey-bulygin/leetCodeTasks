package leetsCode.easy.pageOne;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 */
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
