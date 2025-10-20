package linked_list.medium;

import linked_list.basics.ListNode;

public class MiddleOfLL {
    //Leetcode 876 Middle of the Linked List

    //Tortoise and Hare Algorithm
    //You move one pointer twice the speed of second pointer.
    //If the list has even number of elements, then the middle element is the one that is at the middle of the two pointers.
    //If the list has odd number of elements, then the middle element is the one that is at the middle of the two pointers plus one.

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
