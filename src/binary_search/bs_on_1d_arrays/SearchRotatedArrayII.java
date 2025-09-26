package binary_search.bs_on_1d_arrays;

/**
 * Problem: SearchRotatedArrayII
 * Difficulty: Based on folder structure
 */
public class SearchRotatedArrayII {


    /**
     * Search in Rotated Sorted Array II (with duplicates)
     * Time Complexity: O(log n) average, O(n) worst case, Space Complexity: O(1)
     */
    public boolean search(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == k) return true;

            // Handle duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Left half is sorted
            if(arr[mid] >= arr[low]){
                if(arr[low] <= k && k <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else{
                if(arr[mid] <= k && k <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    // Test cases
    public static void main(String[] args) {
        SearchRotatedArrayII obj = new SearchRotatedArrayII();

        // Test case 1
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println("Test 1: " + obj.search(nums1, target1) + " (Expected: true)");

        // Test case 2
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println("Test 2: " + obj.search(nums2, target2) + " (Expected: false)");

        // Test case 3
        int[] nums3 = {1, 0, 1, 1, 1};
        int target3 = 0;
        System.out.println("Test 3: " + obj.search(nums3, target3) + " (Expected: true)");
    }
}
