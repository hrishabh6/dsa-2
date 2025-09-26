package arrays.hard;

/**
 * Problem: FourSum
 * Difficulty: Based on folder structure
 */
public class FourSum {


    /**
     * Find all unique quadruplets that sum to target (Two Pointer Approach)
     * Time Complexity: O(n³), Space Complexity: O(1) excluding result
     */
    public java.util.List<java.util.List<Integer>> fourSum(int[] nums, int target) {
        java.util.List<java.util.List<Integer>> answer = new java.util.ArrayList<>();
        int n = nums.length;
        java.util.Arrays.sort(nums);

        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1;
                int high = n-1;
                while(low < high) {
                    long sum = (long)nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target) {
                        answer.add(java.util.Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                        while(low < high && nums[low] == nums[low-1]) low++;
                        while(low < high && nums[high] == nums[high+1]) high--;
                    }
                    else if(sum < target) low++;
                    else high--;
                }
            }
        }
        return answer;
    }

    // Test cases
    public static void main(String[] args) {
        FourSum obj = new FourSum();

        // Test case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        java.util.List<java.util.List<Integer>> result1 = obj.fourSum(nums1, target1);
        System.out.println("Test 1: " + result1);

        // Test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        java.util.List<java.util.List<Integer>> result2 = obj.fourSum(nums2, target2);
        System.out.println("Test 2: " + result2);

        // Test case 3
        int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target3 = -294967296;
        java.util.List<java.util.List<Integer>> result3 = obj.fourSum(nums3, target3);
        System.out.println("Test 3: " + result3);
    }
}
