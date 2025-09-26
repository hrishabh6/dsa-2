package binary_search.bs_on_1d_arrays;
/**
 * Problem: BinarySearch
 * Difficulty: Based on folder structure
 */
public class BinarySearch {


    /**
     * Classic Binary Search
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();

        // Test case 1
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Test 1: " + obj.binarySearch(nums1, target1) + " (Expected: 4)");

        // Test case 2
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Test 2: " + obj.binarySearch(nums2, target2) + " (Expected: -1)");

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target3 = 1;
        System.out.println("Test 3: " + obj.binarySearch(nums3, target3) + " (Expected: 0)");
    }
}
