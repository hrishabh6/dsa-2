package arrays.medium;

/**
 * Problem: MajorityElement
 * Difficulty: Based on folder structure
 */
public class MajorityElement {


    /**
     * Boyer-Moore Voting Algorithm to find majority element
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        // Verify if candidate is a majority element
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    // Test cases
    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();

        // Test case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Test 1: " + obj.majorityElement(nums1) + " (Expected: 3)");

        // Test case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Test 2: " + obj.majorityElement(nums2) + " (Expected: 2)");

        // Test case 3
        int[] nums3 = {1, 2, 1, 3, 1, 4, 1, 5, 1, 1, 1, 6, 1, 1, 1, 7};
        System.out.println("Test 3: " + obj.majorityElement(nums3) + " (Expected: 1)");
    }
}
