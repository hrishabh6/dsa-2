package binary_search.bs_on_1d_arrays;

/**
 * Problem: FindPeakElement
 * Difficulty: Based on folder structure
 */
public class FindPeakElement {


    /**
     * Find peak element in array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        int low = 1, high = n - 2;
        while(low <= high){
            int mid = (low + high) / 2;

            // If peak found return it
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) return mid;

            // If on the increasing curve, peak will be on right so eliminate left
            else if(arr[mid] > arr[mid-1]) low = mid + 1;

            // If on decreasing curve, peak will be on left
            else high = mid - 1;
        }
        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();

        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + obj.findPeakElement(nums1) + " (Expected: 2)");

        // Test case 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Test 2: " + obj.findPeakElement(nums2) + " (Expected: 1 or 5)");

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + obj.findPeakElement(nums3) + " (Expected: 4)");
    }
}
