package arrays.easy;

/**
 * Problem: MaxConsecutiveOnes
 * Difficulty: Based on folder structure
 */
public class MaxConsecutiveOnes {


    /**
     * Find the maximum number of consecutive 1s in the array.
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }

    // Test cases
    public static void main(String[] args) {
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();

        // Test case 1
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        System.out.println("Test 1: " + obj.findMaxConsecutiveOnes(nums1) + " (Expected: 3)");

        // Test case 2
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println("Test 2: " + obj.findMaxConsecutiveOnes(nums2) + " (Expected: 2)");

        // Test case 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Test 3: " + obj.findMaxConsecutiveOnes(nums3) + " (Expected: 0)");
    }
}
