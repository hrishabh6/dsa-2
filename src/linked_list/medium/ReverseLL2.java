package linked_list.medium;

import linked_list.basics.ListNode;

public class ReverseLL2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(-1, head);
        dummyNode.next = head;

        ListNode leftPre = dummyNode;
        ListNode curr = head;

        for (int i = 1; i < left; i++) {
            leftPre = leftPre.next;
        }
        curr = leftPre.next;


        ListNode subHead = curr;
        ListNode preNode = null;


        int no = right-left+1;

        for(int i = 0; i < no; i++){
            ListNode nextNode = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr = nextNode;
        }

        leftPre.next = preNode;

        subHead.next = curr;

        return dummyNode.next;

    }
}
