package leetsCode.easy.pageOne;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class SameTreeSolution {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p_l = new TreeNode(2);
        p.left = p_l;

        TreeNode p_l_l = new TreeNode(4);
        p_l.left = p_l_l;

        TreeNode p_l_l_r = new TreeNode(3);
        p_l_l.right = p_l_l_r;

        TreeNode q = new TreeNode(1);
        TreeNode q_l = new TreeNode(4);
        q.left = q_l;

        TreeNode q_l_l = new TreeNode(2);
        q_l.left = q_l_l;

        TreeNode q_l_l_r = new TreeNode(3);
        q_l_l.right = q_l_l_r;


        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null)? true : ( (p != null && q == null) || (p == null && q != null) )?
                false : (p.val != q.val)?
                false : isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}
