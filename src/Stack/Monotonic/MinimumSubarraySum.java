package Stack.Monotonic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MinimumSubarraySum {

    private List<Integer> NSE(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            ans.set(i, st.isEmpty() ? n : st.peek());
            st.push(i);
        }
        return ans;
    }

    // PSEE: Previous Strictly Smaller Element
    private List<Integer> PSEE(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            ans.set(i, st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        List<Integer> nse = NSE(arr);
        List<Integer> psee = PSEE(arr);
        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - psee.get(i);
            long right = nse.get(i) - i;
            total = (total + left * right * arr[i]) % MOD;
        }
        return (int) total;
    }


}