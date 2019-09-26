package leetsCode.easy;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTreeSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);

        root.left = l;

        int depth = new MinimumDepthOfBinaryTreeSolution().minDepth(root);
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return 1 + (leftDepth != 0 && rightDepth != 0?
                Math.min (leftDepth, rightDepth) : Math.max(leftDepth, rightDepth));
    }
}
