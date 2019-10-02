package leetsCode.easy.pageOne;

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
        int[] array = new int[]{0, 1, 2, 3, 4, 5};
        TreeNode bstTree = sortedArrayToBST(array);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return initBST(nums, 0, nums.length - 1);
    }

    private static TreeNode initBST(int[] nums, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(nums[end]);

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = initBST(nums, start, mid - 1);
        root.right = initBST(nums, mid + 1, end);

        return root;
    }

}
