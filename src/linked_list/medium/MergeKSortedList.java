package linked_list.medium;

import linked_list.basics.ListNode;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int val;
    ListNode node;

    Pair(int val, ListNode node){
        this.val = val;
        this.node = node;
    }

    @Override
    public int compareTo(Pair o) {
        return this.val - o.val; //Ascending order
    }
}


public class MergeKSortedList {

    //PQ approach
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(ListNode list : lists){
            if(list != null){
                pq.add(new Pair(list.val, list));
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            temp.next = pair.node;
            temp = temp.next;
            if(pair.node.next != null){
                pq.add(new Pair(pair.node.next.val, pair.node.next));
            }
        }

        return dummyNode.next;
    }

}
