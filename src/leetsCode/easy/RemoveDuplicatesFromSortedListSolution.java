package leetsCode.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedListSolution {
    public static void main(String[] args) {
        //1->1->2->3->3
        ListNode node = new ListNode(1);
            ListNode node1 = new ListNode(1);
            node.next = node1;
            ListNode node2 = new ListNode(1);
            node1.next = node2;


        node = deleteDuplicates(node);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (head != null) {
            ListNode headNext = head.next;
            if ( headNext != null && head.val == headNext.val)
                head.next = headNext.next;
            else
                head = headNext;
        }

        return tmp;
    }
}
