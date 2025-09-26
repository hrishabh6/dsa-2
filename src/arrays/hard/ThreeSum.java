package arrays.hard;
/**
 * Problem: ThreeSum
 * Difficulty: Based on folder structure
 */
public class ThreeSum {


    /**
     * Find all unique triplets that sum to zero (Two Pointer Approach)
     * Time Complexity: O(n²), Space Complexity: O(1) excluding result
     */
    public java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
        java.util.List<java.util.List<Integer>> answer = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                } else if(sum < 0){
                    j++;
                } else {
                    answer.add(java.util.Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Skip duplicates
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return answer;
    }

    // Test cases
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();

        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        java.util.List<java.util.List<Integer>> result1 = obj.threeSum(nums1);
        System.out.println("Test 1: " + result1);

        // Test case 2
        int[] nums2 = {0, 1, 1};
        java.util.List<java.util.List<Integer>> result2 = obj.threeSum(nums2);
        System.out.println("Test 2: " + result2);

        // Test case 3
        int[] nums3 = {0, 0, 0};
        java.util.List<java.util.List<Integer>> result3 = obj.threeSum(nums3);
        System.out.println("Test 3: " + result3);
    }
}
