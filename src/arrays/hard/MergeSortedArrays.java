package arrays.hard;
/**
 * Problem: MergeSortedArrays
 * Difficulty: Based on folder structure
 */
public class MergeSortedArrays {


    /**
     * Merge two sorted arrays without extra space
     * Time Complexity: O((n+m)log(n+m)), Space Complexity: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;

        // Move larger elements to nums2
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int tmp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = tmp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort both arrays
        java.util.Arrays.sort(nums1, 0, m);
        java.util.Arrays.sort(nums2);

        // Copy nums2 to nums1
        for (int k = 0; k < n; k++) {
            nums1[m + k] = nums2[k];
        }
    }

    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Test cases
    public static void main(String[] args) {
        MergeSortedArrays obj = new MergeSortedArrays();

        // Test case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        System.out.println("Test 1 - Before merge:");
        System.out.print("nums1: ");
        obj.printArray(java.util.Arrays.copyOf(nums1, 3));
        System.out.print("nums2: ");
        obj.printArray(nums2);
        obj.merge(nums1, 3, nums2, 3);
        System.out.print("After merge: ");
        obj.printArray(nums1);

        // Test case 2
        int[] nums3 = {1, 0};
        int[] nums4 = {2};
        System.out.println("\nTest 2:");
        obj.merge(nums3, 1, nums4, 1);
        System.out.print("Result: ");
        obj.printArray(nums3);
    }
}
