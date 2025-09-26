package arrays.medium;

/**
 * Problem: SetMatrixZeros
 * Difficulty: Based on folder structure
 */
public class SetMatrixZeros {


    /**
     * Set entire row and column to zero if any element is zero
     * Time Complexity: O(m*n), Space Complexity: O(1)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first column should be zero
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Check if first row should be zero
        for(int i = 0; i<n; i++){
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Mark zeros using first row and column
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeros based on marks
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row to zero if needed
        if(firstRowZero){
            for(int i = 0; i < n ; i++){
                matrix[0][i] = 0;
            }
        }

        // Set first column to zero if needed
        if(firstColZero){
            for(int i = 0; i < m ; i++){
                matrix[i][0] = 0;
            }
        }
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Test cases
    public static void main(String[] args) {
        SetMatrixZeros obj = new SetMatrixZeros();

        // Test case 1
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("Test 1 - Before:");
        obj.printMatrix(matrix1);
        obj.setZeroes(matrix1);
        System.out.println("After:");
        obj.printMatrix(matrix1);

        // Test case 2
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("\nTest 2 - Before:");
        obj.printMatrix(matrix2);
        obj.setZeroes(matrix2);
        System.out.println("After:");
        obj.printMatrix(matrix2);
    }
}
