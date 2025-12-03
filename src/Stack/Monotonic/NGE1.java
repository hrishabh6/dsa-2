package Stack.Monotonic;

import java.util.HashMap;
import java.util.Stack;

public class NGE1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Hashmaps and monotonic stack combined
        Stack<Integer> stack = new Stack<>();
        //Key = num, value = next greater element
        HashMap<Integer, Integer> map = new HashMap<>();
        //Start from behind
        int[] nge = new int[nums1.length];
        for(int i = nums2.length-1; i >= 0; i--){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()) map.put(nums2[i], stack.peek());

            stack.push(nums2[i]);
        }

        //Build the result
        for(int i = 0; i < nums1.length; i++){
            nge[i] = map.getOrDefault(nums1[i], -1);

        }
        return nge;
    }

}
