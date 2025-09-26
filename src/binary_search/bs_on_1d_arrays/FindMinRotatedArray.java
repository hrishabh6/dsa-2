package binary_search.bs_on_1d_arrays;

/**
 * Problem: FindMinRotatedArray
 * Difficulty: Based on folder structure
 */
public class FindMinRotatedArray {


    /**
     * Find minimum element in rotated sorted array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;

            // If the search space is fully sorted
            if(arr[low] <= arr[high]){
                ans = Math.min(arr[low], ans);
                break;
            }

            // Left half is sorted
            if(arr[low] <= arr[mid]){
                ans = Math.min(arr[low], ans);
                low = mid + 1;
            } else {
                ans = Math.min(arr[mid], ans);
                high = mid - 1;
            }
        }
        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        FindMinRotatedArray obj = new FindMinRotatedArray();

        // Test case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test 1: " + obj.findMin(nums1) + " (Expected: 1)");

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test 2: " + obj.findMin(nums2) + " (Expected: 0)");

        // Test case 3
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Test 3: " + obj.findMin(nums3) + " (Expected: 11)");
    }
}
