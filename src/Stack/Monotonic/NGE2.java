package Stack.Monotonic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NGE2 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];

            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            if (i < n) {
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(curr);
        }

        return ans;
    }


}
