package linked_list.medium;

import linked_list.basics.ListNode;

public class Add2Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2, dummy = new ListNode(-1), current = dummy;
        int carry = 0;
        while(t1 != null || t2 != null){
            int sum = carry;
            if(t1 != null) sum += t1.val;
            if(t2 != null) sum += t2.val;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }

        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
