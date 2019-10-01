package leetsCode.easy;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedListsSolution {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode a1 = new ListNode(1);
        headA.next = a1;
        ListNode a2 = new ListNode(8);
        a1.next = a2;
        ListNode a3 = new ListNode(4);
        a2.next = a3;
        ListNode a4 = new ListNode(5);
        a3.next = a4;

        ListNode headB = new ListNode(5);
        ListNode b1 = new ListNode(0);
        headB.next = b1;
        ListNode b2 = new ListNode(1);
        b1.next = b2;
        ListNode b3 = new ListNode(8);
        b2.next = a2;

        ListNode answer = new IntersectionOfTwoLinkedListsSolution()
                .getIntersectionNode(headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int lengthA = getLengthNode(headA);
        int lengthB = getLengthNode(headB);
        int delta = Math.abs(lengthA - lengthB);

        if (delta == 0)
            return intersect(headA, headB);

        ListNode stepNode = lengthA > lengthB? getStepNode(headA, delta) : getStepNode(headB, delta);

        return lengthA > lengthB?
                intersect(stepNode, headB) : intersect(headA, stepNode);
    }

    private ListNode intersect(ListNode node1, ListNode node2) {
        if (node1 == node2)
            return node1;

        return node1.next != null && node2.next != null?
                intersect(node1.next, node2.next) : null;
    }

    private ListNode getStepNode(ListNode node, int delta) {
        while(delta-- != 0)
            node = node.next;

        return node;
    }

    private int getLengthNode(ListNode node) {
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
}

