package leetsCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *
 *  -10  5
 */
public class ConvertSortedArrayToBinarySearchTreeSolution {
    public static void main(String[] args) {
        int[] array = new int[]{-10, -3, 0, 5, 9};
        TreeNode bstTree = sortedArrayToBST(array);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        ArrayList<Integer> numsList = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        int mid = 0;

        if (numsList.size() % 2 == 0)
            mid = numsList.size() / 2;
        else
            mid = (numsList.size() - 1) / 2;
        
        TreeNode bstRoot = new TreeNode(numsList.get(mid));
        bstRoot.left = new TreeNode(numsList.get(mid - 1));
        bstRoot.right = new TreeNode(numsList.get(numsList.size() - 1));

        initBSTTree(bstRoot.left, bstRoot.right,
                    new ArrayList<Integer>(numsList.subList(0, mid - 1)),
                    new ArrayList<Integer>(numsList.subList(mid + 1, numsList.size() - 1)));

        return bstRoot;
    }

    private static void initBSTTree(TreeNode left, TreeNode right,
                                    ArrayList<Integer> leftNums, ArrayList<Integer> rightNums) {
        if (!leftNums.isEmpty())
            left.left = new TreeNode(leftNums.get(leftNums.size() - 1));
        if (!rightNums.isEmpty())
            right.left = new TreeNode(rightNums.get(0));

        if (leftNums.isEmpty() && rightNums.isEmpty())
            return;

        initBSTTree(left, right,
                new ArrayList<>(leftNums.subList(1, leftNums.size())),
                new ArrayList<>(rightNums.subList(0, rightNums.size() - 1)));
    }
}
