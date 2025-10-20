package linked_list.basics;

public class BasicOps {
    public ListNode addANode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if(head == null){
            return newNode;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public ListNode deleteANode(ListNode current, int val) {
        if(current == null) return null;
        if(current.val == val){
            return current.next;
        }
        while(current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
                //To delet first occurance uncomment below line
                //break;
            }

            current = current.next;
        }
        return current;
    }

    public ListNode insertANodeAtEnd(ListNode head, int val) {
        if(head == null){
            return new ListNode(val);
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new ListNode(val);
        return head;
    }

    public ListNode insertANodeAtStart(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }

    public ListNode insertANodeAtPosition(ListNode head, int val, int position) {
        if (position == 0 || head == null) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            return newNode;
        }

        ListNode current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public int length(ListNode head) {
        if (head == null) return 0;
        ListNode current = head;
        int count = 1;
        while(current.next != null){
            current = current.next;
            count++;
        }
        return count;
    }

}
