package linked_list.medium;

import linked_list.basics.ListNode;

public class Rotate {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k == 0) return head;

        //First find length
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len += 1;
        }

        //Find no of operations
        int op = k%len;
        if(op == 0) return head;

        ListNode temp = head;

        for (int i = 1; i < (len-op); i++) {
            temp = temp.next;
        }

        //now rearrange the pointers
        tail.next = head;
        head = temp.next;
        temp.next = null;

        return head;
    }



}
