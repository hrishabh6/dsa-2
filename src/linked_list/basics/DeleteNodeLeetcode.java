package linked_list.basics;

public class DeleteNodeLeetcode {
    //Leetcode 237. Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        //Given the node to delete not the head
        //Intuition :
//        How to become another person in the world? Two steps.
//        One, change your appearance to whom you want to be.
//        Two, kill that person.

        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;

    }
}
