package Stack.Monotonic;

import java.util.Stack;

public class LargestRectInHistogram {

    private int[] nse(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n : stack.peek(); // index of next smaller element
            stack.push(i);
        }
        return ans;
    }

    private int[] pse(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek(); // index of previous smaller element
            stack.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nse = nse(heights);
        int[] pse = pse(heights);

        int ans = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = pse[i];
            int right = nse[i];
            ans = Math.max(ans, (right - left - 1) * height);
        }
        return ans;
    }

    // Build vertical heights of consecutive '1's for each cell
    private int[][] buildHeights(char[][] matrix){
        int n = matrix.length;
        if (n == 0) return new int[0][0];
        int m = matrix[0].length;

        int[][] heights = new int[n][m];

        for(int j = 0; j < m; j++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if (matrix[i][j] == '1') {
                    sum++;
                } else {
                    sum = 0;
                }
                heights[i][j] = sum;
            }
        }
        return heights;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] heights = buildHeights(matrix);
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++){
            maxArea = Math.max(maxArea, largestRectangleArea(heights[i]));
        }
        return maxArea;
    }
}
