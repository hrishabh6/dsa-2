package binary_search.bs_on_2d;

import java.lang.reflect.Array;

public class Find_Peak_2 {
    public static int getMaxRowIndexInColumn(int[][] matrix, int colNo) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix is empty or null");
        }
        if (colNo < 0 || colNo >= matrix[0].length) {
            throw new IllegalArgumentException("Invalid column number");
        }

        int maxRow = 0;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][colNo] > matrix[maxRow][colNo]) {
                maxRow = i;
            }
        }
        return maxRow;
    }

    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length;
        while(low <= high){
            int mid = low + (high - low)/2;
            int rowNo = getMaxRowIndexInColumn(mat, mid);
            int left = mid - 1 > 0 ? mat[rowNo][mid - 1] : -1;
            int right = mid + 1 > mat[0].length ? mat[rowNo][mid + 1] : -1;
            int value = mat[rowNo][mid];
            if(value > left && value > right){
                return new int[]{rowNo, mid};
            }
            else if (left > value) high = mid-1;
            else {
                low = mid+1;
            }
        }
        return new int[]{-1, -1};
    }
}
