package Stack.Monotonic;

public class MaximalRect {

    private LargestRectInHistogram largestRectangleArea;

    private int[][] prefixSum(char[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] prefix = new int[n][m];

        for(int j = 0; j < m; j++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += matrix[i][j];
                if(matrix[i][j] == 0){
                    sum = 0;
                    prefix[i][j] = sum;
                }
            }
        }
        return prefix;

    }

    public int maximalRectangle(char[][] matrix) {
        int[][] prefix = prefixSum(matrix);
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++){
             maxArea = Math.max(maxArea, largestRectangleArea.largestRectangleArea(prefix[i]));
        }
        return maxArea;
    }

}
