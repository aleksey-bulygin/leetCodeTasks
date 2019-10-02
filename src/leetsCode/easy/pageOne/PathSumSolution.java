package leetsCode.easy.pageOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSumSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        boolean answer = new PathSumSolution().hasPathSum(root, 1);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> sums = new ArrayList<>();

        if (root != null) {
            if (root.left != null || root.right != null) {
                searchSumsPaths(root.left, root.val, sums);
                searchSumsPaths(root.right, root.val, sums);
            } else {
                sums.add(root.val);
            }
        }
        else
            return false;

        return sums.stream().filter(x -> x == sum).findFirst().isPresent();
    }

    private void searchSumsPaths(TreeNode node, int sum, List<Integer> sums) {
        if (node != null) {
            sum += node.val;

            if (node.left == null && node.right == null)
                sums.add(sum);
            else {
                searchSumsPaths(node.left, sum, sums);
                searchSumsPaths(node.right, sum, sums);
            }
        }
    }

}
