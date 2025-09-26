package binary_search.bs_on_1d_arrays;

/**
 * Problem: SingleElementSorted
 * Difficulty: Based on folder structure
 */
public class SingleElementSorted {


    /**
     * Find single element in sorted array where every other element appears twice
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];

        // Check for first element
        if(arr[0] != arr[1]) return arr[0];

        // Check for last element
        if(arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1, high = n - 2;
        while(low <= high){
            int mid = (low + high) / 2;

            // Return element if found
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
                return arr[mid];
            }

            // Check if we are in left half
            if((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
               (mid % 2 == 0 && arr[mid] == arr[mid + 1])){
                // Eliminate the left half as element exists on right half
                low = mid + 1;
            }
            // else we are in right half
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        SingleElementSorted obj = new SingleElementSorted();

        // Test case 1
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Test 1: " + obj.singleNonDuplicate(nums1) + " (Expected: 2)");

        // Test case 2
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println("Test 2: " + obj.singleNonDuplicate(nums2) + " (Expected: 10)");

        // Test case 3
        int[] nums3 = {1, 1, 2, 2, 3};
        System.out.println("Test 3: " + obj.singleNonDuplicate(nums3) + " (Expected: 3)");
    }
}
