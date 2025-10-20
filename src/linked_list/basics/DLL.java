package linked_list.basics;

import java.util.ArrayList;

public class DLL extends ListNode{
    public ListNode prev;

    DLL(int x){
        super(x);
        this.prev = null;
    }

    DLL(int x, ListNode next, ListNode prev){
        super(x, next);
        this.prev = prev;
    }

    DLL arrayToLinkedList(int[] arr){
        if (arr == null || arr.length == 0) return null;

        DLL head = new DLL(arr[0], null, null);
        DLL prev = head;

        for(int i = 1; i < arr.length; i++){
            DLL temp = new DLL(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    int[] dllToArrayList(DLL head) {
        ArrayList<Integer> list = new ArrayList<>();
        DLL temp = head;

        // Traverse the entire DLL safely
        while (temp != null) {
            list.add(temp.val);
            temp = (DLL) temp.next;
        }

        // Convert ArrayList to int[]
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

}
