package arrays.medium;

/**
 * Problem: RearrangeArray
 * Difficulty: Based on folder structure
 */
public class RearrangeArray {


    /**
     * Rearrange array in alternating positive and negative items
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public int[] rearrangeArray(int[] nums) {
        int[] solution = new int[nums.length];
        int pos = 0, neg = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                solution[pos] = nums[i];
                pos += 2;
            } else if (nums[i] < 0) {
                solution[neg] = nums[i];
                neg += 2;
            }
        }
        return solution;
    }

    // Test cases
    public static void main(String[] args) {
        RearrangeArray obj = new RearrangeArray();

        // Test case 1
        int[] nums1 = {3, 1, -2, -5, 2, -4};
        int[] result1 = obj.rearrangeArray(nums1);
        System.out.print("Test 1: ");
        for (int num : result1) System.out.print(num + " ");
        System.out.println();

        // Test case 2
        int[] nums2 = {-1, 1};
        int[] result2 = obj.rearrangeArray(nums2);
        System.out.print("Test 2: ");
        for (int num : result2) System.out.print(num + " ");
        System.out.println();

        // Test case 3
        int[] nums3 = {1, 2, -3, -1, -2, 3};
        int[] result3 = obj.rearrangeArray(nums3);
        System.out.print("Test 3: ");
        for (int num : result3) System.out.print(num + " ");
        System.out.println();
    }
}
