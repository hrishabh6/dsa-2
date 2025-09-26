package arrays.medium;

/**
 * Problem: SortColors
 * Difficulty: Based on folder structure
 */
public class SortColors {


    /**
     * Dutch National Flag Problem - Sort array of 0s, 1s and 2s
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Test cases
    public static void main(String[] args) {
        SortColors obj = new SortColors();

        // Test case 1
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        obj.sortColors(nums1);
        System.out.print("Test 1: ");
        for (int num : nums1) System.out.print(num + " ");
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 0, 1};
        obj.sortColors(nums2);
        System.out.print("Test 2: ");
        for (int num : nums2) System.out.print(num + " ");
        System.out.println();

        // Test case 3
        int[] nums3 = {0, 0, 2, 1, 1, 0, 2, 2, 1, 0};
        obj.sortColors(nums3);
        System.out.print("Test 3: ");
        for (int num : nums3) System.out.print(num + " ");
        System.out.println();
    }
}
