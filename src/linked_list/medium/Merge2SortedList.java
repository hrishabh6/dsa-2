package linked_list.medium;

import linked_list.basics.ListNode;

public class Merge2SortedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1, null);
        ListNode temp = dummyNode;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 != null){
            temp.next = list1;
        } else if(list2 != null){
            temp.next = list2;
        }

        return dummyNode.next;
    }

}
