package binary_search.bs_on_answers;

/**
 * Problem: SmallestDivisor
 * Difficulty: Based on folder structure
 */
public class SmallestDivisor {


    /**
     * Find the smallest divisor given a threshold
     * Time Complexity: O(n * log(max(nums))), Space Complexity: O(1)
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = findMax(nums);
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isDivisorValid(nums, threshold, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Utility function to check if divisor crosses threshold
    private boolean isDivisorValid(int[] arr, int threshold, int divisor){
        int sum = 0;
        for(int num : arr){
            sum += (num + divisor - 1) / divisor; // Ceiling division
            if(sum > threshold) return false; // Early exit
        }
        return true;
    }

    private int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max, num);
        return max;
    }

    // Test cases
    public static void main(String[] args) {
        SmallestDivisor obj = new SmallestDivisor();

        // Test case 1
        int[] nums1 = {1, 2, 5, 9};
        int threshold1 = 6;
        System.out.println("Test 1: " + obj.smallestDivisor(nums1, threshold1) + " (Expected: 5)");

        // Test case 2
        int[] nums2 = {44, 22, 33, 11, 1};
        int threshold2 = 5;
        System.out.println("Test 2: " + obj.smallestDivisor(nums2, threshold2) + " (Expected: 44)");

        // Test case 3
        int[] nums3 = {2, 3, 5, 7, 11};
        int threshold3 = 11;
        System.out.println("Test 3: " + obj.smallestDivisor(nums3, threshold3) + " (Expected: 3)");
    }
}
