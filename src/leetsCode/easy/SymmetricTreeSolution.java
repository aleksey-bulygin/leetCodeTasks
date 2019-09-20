package leetsCode.easy;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTreeSolution {
    public static void main(String[] args) {

       TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);
        root.left = l1;
        root.right = r1;

        TreeNode l1l = new TreeNode(4);
        TreeNode l1r = new TreeNode(3);
        l1.left = l1l;
        l1.right = l1r;

        TreeNode r1l = new TreeNode(3);
        TreeNode r1r = new TreeNode(4);
        r1.left = r1l;
        r1.right = r1r;

/**
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);
        root.left = l1;
        root.right = r1;

        TreeNode l1l = new TreeNode(2);
     //   TreeNode l1r = new TreeNode(4);
        l1.left = l1l;
      //  l1.right = l1r;

        TreeNode r1l = new TreeNode(2);
   //     TreeNode r1r = new TreeNode(3);
        r1.left = r1l;
     //   r1.right = r1r;
         **/
        System.out.print(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        return (left == null && right == null)? true :
                (left == null || right == null)? false :
                        (left.val != right.val)? false :
                                isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
