package arrays.easy;

/**
 * Problem: TwoSum
 * Difficulty: Based on folder structure
 */
public class TwoSum {

    /**
     * Return the indices of the two numbers such that they add up to a specific target.
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * If array is sorted then we can use two pointers
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public int[] twoSum_sorted(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum == target) {
                return new int[] {i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {-1, -1};
    }

    // Test cases
    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = obj.twoSum(nums1, target1);
        System.out.println("Test 1: [" + result1[0] + ", " + result1[1] + "]");

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = obj.twoSum(nums2, target2);
        System.out.println("Test 2: [" + result2[0] + ", " + result2[1] + "]");

        // Test case 3 - sorted array
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result3 = obj.twoSum_sorted(sorted, 17);
        System.out.println("Test 3 (sorted): [" + result3[0] + ", " + result3[1] + "]");
    }
}
