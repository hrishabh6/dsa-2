package arrays.hard;

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int firstTrueIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Determine if feasible: target is at mid or should be to its left
            boolean feasible;
            if (nums[0] <= nums[mid]) {
                // Left half is sorted
                feasible = nums[0] <= target && target <= nums[mid];
            } else {
                // Right half is sorted
                // Feasible if target is NOT in the sorted right half
                feasible = !(nums[mid] < target && target <= nums[n - 1]);
            }

            if (feasible) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Check if the element at firstTrueIndex is the target
        if (firstTrueIndex == -1) {
            return -1;
        }
        return nums[firstTrueIndex] == target ? firstTrueIndex : -1;
    }

}
