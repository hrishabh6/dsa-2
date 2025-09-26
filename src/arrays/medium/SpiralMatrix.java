package arrays.medium;

/**
 * Problem: SpiralMatrix
 * Difficulty: Based on folder structure
 */
public class SpiralMatrix {


    /**
     * Print matrix in spiral order
     * Time Complexity: O(m*n), Space Complexity: O(1) excluding result
     */
    public java.util.List<Integer> spiralOrder(int[][] matrix) {
        java.util.List<Integer> answer = new java.util.ArrayList<>();
        if(matrix.length == 0) return answer;

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length -1;

        while(top <= bottom && left <= right){
            // Traverse right
            for(int i = left; i <= right; i++){
                answer.add(matrix[top][i]);
            }
            top++;

            // Traverse down
            for(int i = top; i <= bottom; i++){
                answer.add(matrix[i][right]);
            }
            right--;

            // Traverse left (if still valid row)
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse up (if still valid column)
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }
        return answer;
    }

    // Test cases
    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();

        // Test case 1
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        java.util.List<Integer> result1 = obj.spiralOrder(matrix1);
        System.out.println("Test 1: " + result1);

        // Test case 2
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        java.util.List<Integer> result2 = obj.spiralOrder(matrix2);
        System.out.println("Test 2: " + result2);

        // Test case 3
        int[][] matrix3 = {{1}};
        java.util.List<Integer> result3 = obj.spiralOrder(matrix3);
        System.out.println("Test 3: " + result3);
    }
}
