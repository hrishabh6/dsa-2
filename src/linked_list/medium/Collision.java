package linked_list.medium;

import linked_list.basics.ListNode;

public class Collision {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode currentA = headA, currentB = headB;
        while(currentA != currentB){
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }
        return currentA;
    }

}
