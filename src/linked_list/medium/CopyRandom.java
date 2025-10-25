package linked_list.medium;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandom {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node temp = head;

        // Step 1: Create copy nodes and interleave them
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Step 2: Set random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Extract the copy list
        Node dummy = new Node(-1);
        Node copyCurr = dummy;
        temp = head;

        while (temp != null) {
            Node copy = temp.next;
            temp.next = copy.next; // restore original list
            copyCurr.next = copy;
            copyCurr = copy;
            temp = temp.next;
        }

        return dummy.next;
    }

}
