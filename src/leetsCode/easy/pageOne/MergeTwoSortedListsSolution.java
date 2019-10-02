package leetsCode.easy.pageOne;

import java.util.Objects;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedListsSolution {
    public static void main(String[] args) {
        ListNode l1_main = null;

        ListNode l2_main = new ListNode(0);

        ListNode outList = mergeTwoLists(l1_main, l2_main);
        while (outList != null) {
            System.out.print(outList.val + " -> ");
            outList = outList.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        int minVal = 0;
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                minVal = l1.val;
                l1 = l1.next;
            } else {
                minVal = l2.val;
                l2 = l2.next;
            }
        } else {
            if (l1 == null && l2 != null) {
                minVal = l2.val;
                l2 = l2.next;
            }
            else if (l2 == null && l1 != null) {
                minVal = l1.val;
                l1 = l1.next;
            }
        }

        ListNode rootNode = new ListNode(minVal);
        minVal = Integer.MIN_VALUE;

        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                minVal = l1.val;
                l1 = l1.next;
            } else {
                minVal = l2.val;
                l2 = l2.next;
            }
        } else {
            if (l1 == null && l2 != null) {
                minVal = l2.val;
                l2 = l2.next;
            }
            else if (l2 == null && l1 != null) {
                minVal = l1.val;
                l1 = l1.next;
            }
        }

        ListNode currentNode = new ListNode(minVal);

        if (minVal > Integer.MIN_VALUE)
            rootNode.next = currentNode;
        else
            rootNode.next = null;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    minVal = l1.val;
                    l1 = l1.next;
                } else {
                    minVal = l2.val;
                    l2 = l2.next;
                }
                currentNode.next = new ListNode(minVal);
                currentNode = currentNode.next;
            } else {
                if (l1 == null) {
                    minVal = l2.val;
                    l2 = l2.next;
                } else {
                    minVal = l1.val;
                    l1 = l1.next;
                }
                currentNode.next = new ListNode(minVal);
                currentNode = currentNode.next;
            }
        }

        return rootNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
