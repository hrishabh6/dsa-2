package linked_list.medium;

import linked_list.basics.ListNode;

public class ReverseKNodes {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while(count < k){
            if(temp == null) return head;
            temp = temp.next;
            count++;
        }

        //Recursively call for rest of the linklist
        ListNode newNode = reverseKGroup(temp, k);

        //Reverse the current k group
        temp = head; count = 0;
        while(count < k){
            ListNode next = temp.next;
            temp.next = newNode;

            newNode = temp;
            temp = next;
            count++;
        }
        return newNode;
    }

}
