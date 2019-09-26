package leetsCode.easy;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycleSolution {
    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(3);
        listNode1.next = new ListNode1(2);
        listNode1.next.next = new ListNode1(0);
        listNode1.next.next.next = new ListNode1(-4);
        listNode1.next.next.next.next = listNode1.next;


        System.out.print(new LinkedListCycleSolution().hasCycle(listNode1));
    }

    public boolean hasCycle(ListNode1 head) {
        if (head == null || head.next == null)
            return false;

        ListNode1 slow = head;
        ListNode1 fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode1{
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
        next = null;
    }
}