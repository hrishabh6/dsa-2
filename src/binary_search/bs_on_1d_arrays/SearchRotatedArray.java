package binary_search.bs_on_1d_arrays;

/**
 * Problem: SearchRotatedArray
 * Difficulty: Based on folder structure
 */
public class SearchRotatedArray {


    /**
     * Search in Rotated Sorted Array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int search(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == k) return mid;

            // The left half is sorted
            if (arr[mid] >= arr[low]) {
                if(arr[low] <= k && k <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // The right half is sorted
            else {
                if(arr[mid] <= k && k <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        SearchRotatedArray obj = new SearchRotatedArray();

        // Test case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Test 1: " + obj.search(nums1, target1) + " (Expected: 4)");

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Test 2: " + obj.search(nums2, target2) + " (Expected: -1)");

        // Test case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Test 3: " + obj.search(nums3, target3) + " (Expected: -1)");
    }
}
