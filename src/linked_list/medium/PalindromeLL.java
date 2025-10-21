package linked_list.medium;

import linked_list.basics.ListNode;

public class PalindromeLL {

    public boolean isPalindrome(ListNode head) {
        //Find middle first
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step 2 : Reverse the second half
        ReverseLL reverseLL = new ReverseLL();
        slow = reverseLL.reverseList(slow.next);

        //Step 3 : Comparision
        fast = head;
        while(slow != null){
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

}
