package leetsCode.easy.pageOne;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 *     a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * Return false.
 */
public class BalancedBinaryTreeSolution {

    public static void main(String[] args) {
        /**
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2);
        root.left = l;
        root.right = r;
        
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(3);
        l.left = ll;
        l.right = lr;
        
        TreeNode lll = new TreeNode(4);
        TreeNode llr = new TreeNode(4);
        ll.left = lll;
        ll.right = llr;

        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(3);
        l.left = ll;
        l.right = lr;

        TreeNode lll = new TreeNode(4);
        TreeNode llr = new TreeNode(4);
        ll.left = lll;
        ll.right = llr;
         **/

        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(3);
        l.left = ll;
        TreeNode lll = new TreeNode(4);
        ll.left = lll;

        TreeNode rr = new TreeNode(3);
        r.right = rr;
        TreeNode rrr = new TreeNode(4);
        rr.right = rrr;

        boolean answer = new BalancedBinaryTreeSolution().isBalanced(root);

    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null )
            return true;
        
        int countLeftLevel = searchCountLevel(root.left);
        int countRightLevel = searchCountLevel(root.right);

        return Math.abs(countLeftLevel - countRightLevel) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int searchCountLevel(final TreeNode node) {
        if (node == null)
           return -1;

         return  (1 + Math.max(searchCountLevel(node.left), searchCountLevel(node.right)));
    }
}
