package Stack.Monotonic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            if (!stack.isEmpty() && stack.peekFirst() <= i-k){
                stack.pollFirst();
            }
            while(!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]){
                stack.pollLast();
            }
            stack.offerLast(i);
            if(i >= k-1){
                ans[i-k+1] = nums[stack.peekFirst()];
            }
        }
        return ans;
    }

}
