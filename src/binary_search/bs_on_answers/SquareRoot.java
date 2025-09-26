package binary_search.bs_on_answers;

/**
 * Problem: SquareRoot
 * Difficulty: Based on folder structure
 */
public class SquareRoot {


    /**
     * Find square root of a number using binary search
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int low = 1, high = x / 2, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long val = (long) mid * mid; // avoid overflow

            if (val == x) {
                return mid;  // exact square root
            } else if (val < x) {
                ans = mid;   // candidate
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        SquareRoot obj = new SquareRoot();

        // Test case 1
        int x1 = 4;
        System.out.println("Test 1: sqrt(" + x1 + ") = " + obj.mySqrt(x1) + " (Expected: 2)");

        // Test case 2
        int x2 = 8;
        System.out.println("Test 2: sqrt(" + x2 + ") = " + obj.mySqrt(x2) + " (Expected: 2)");

        // Test case 3
        int x3 = 16;
        System.out.println("Test 3: sqrt(" + x3 + ") = " + obj.mySqrt(x3) + " (Expected: 4)");
    }
}
