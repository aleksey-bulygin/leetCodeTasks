package leetsCode.medium.pageOne;

import java.math.BigInteger;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbersSolution {
    public static void main(String[] args) {
        /**
        ListNode nodeA = new ListNode(0);
        ListNode a1 = new ListNode(4);
        nodeA.next = a1;
        ListNode a2 = new ListNode(3);
        a1.next = a2;

        ListNode nodeB = new ListNode(0);
        ListNode b1 = new ListNode(6);
        nodeB.next = b1;
        ListNode b2 = new ListNode(4);
        b1.next = b2;
        **/
        ListNode nodeA = new ListNode(9);

        ListNode nodeB = new ListNode(1);
        ListNode b1 = new ListNode(9);
        nodeB.next = b1;
        ListNode b2 = new ListNode(9);
        b1.next = b2;
        ListNode b3 = new ListNode(9);
        b2.next = b3;

        ListNode b4 = new ListNode(9);
        b3.next = b4;
        ListNode b5 = new ListNode(9);
        b4.next = b5;
        ListNode b6 = new ListNode(9);
        b5.next = b6;

        ListNode b7 = new ListNode(9);
        b6.next = b7;
        ListNode b8 = new ListNode(9);
        b7.next = b8;
        ListNode b9 = new ListNode(9);
        b8.next = b9;

        ListNode result = new AddTwoNumbersSolution().addTwoNumbers(nodeA, nodeB);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = new BigInteger(getSum(l1, new StringBuilder())).add(new BigInteger(getSum(l2, new StringBuilder())));

        return sum.compareTo(BigInteger.ZERO) > 0 ? decomposition(sum) : new ListNode(0);
    }

    private ListNode decomposition(BigInteger sum) {
        if (sum.compareTo(BigInteger.ZERO) > 0 ) {
            BigInteger mod = sum.mod(new BigInteger("10"));
            ListNode node = new ListNode(Integer.parseInt(String.valueOf(mod)));
            node.next = decomposition(sum.divide(new BigInteger("10")));

            return node;
        }

        return null;
    }

    private String getSum(ListNode node, StringBuilder sb) {
        if (node != null) {
            getSum(node.next, sb);
            return sb.append(node.val).toString();
        }

        return "";
    }
}
