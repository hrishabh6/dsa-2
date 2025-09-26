package arrays.medium;

/**
 * Problem: MaxSubArray
 * Difficulty: Based on folder structure
 */
public class MaxSubArray {


    /**
     * Kadane's Algorithm for maximum subarray sum
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            max = Math.max(max, currentSum);
        }
        return max;
    }

    // Test cases
    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test 1: " + obj.maxSubArray(nums1) + " (Expected: 6)");

        // Test case 2
        int[] nums2 = {1};
        System.out.println("Test 2: " + obj.maxSubArray(nums2) + " (Expected: 1)");

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Test 3: " + obj.maxSubArray(nums3) + " (Expected: 23)");
    }
}
