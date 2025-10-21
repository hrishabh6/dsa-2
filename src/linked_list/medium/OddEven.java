package linked_list.medium;

import linked_list.basics.ListNode;

public class OddEven {

    public ListNode oddEvenList(ListNode head) {
        //Preserve first even node

        if(head == null || head.next == null) return head;

        ListNode evenHead = head.next;

        ListNode odd = head, even = evenHead;
        while(even != null && even.next != null){
            //Link odd
            odd.next = even.next;
            odd = odd.next;

            //Link even
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
