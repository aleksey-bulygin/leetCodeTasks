package leetsCode.easy;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(4);
                l.left = ll;

      //  TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(5);
    //    r.left = rl;
        r.right = rr;

        List<List<Integer>> answer = levelOrderBottom(root);
        Collections.reverse(answer);

        for (List<Integer> list : answer) {
            list.stream().forEach(System.out::print);
            System.out.println();
        }
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>( Arrays.asList(root.val)) );

        visit(new ArrayList<>( Arrays.asList(root.left, root.right)), out);

        return out.stream().
                filter(o -> o != null && !o.isEmpty()).
                collect(Collectors.toList());
    }

    private static void visit(List<TreeNode> lvl, List<List<Integer>> out) {
        if (lvl.isEmpty() || lvl == null)
            return;
        List<Integer> vals = lvl.stream().
                filter(l -> l != null).
                map(l -> l.val).collect(Collectors.toList());
        out.add(vals);

        List<TreeNode> newLvl = lvl.stream().
                filter(l -> l != null).
                map(l -> Arrays.asList(l.left, l.right))
                .flatMap(treeNodes -> treeNodes.stream()).
                        collect(Collectors.toList());

        visit(newLvl, out);
    }
}
