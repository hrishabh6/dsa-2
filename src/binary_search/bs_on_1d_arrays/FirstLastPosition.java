package binary_search.bs_on_1d_arrays;

public class FirstLastPosition {
    private int[] nums;
    private int n;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.n = nums.length;

        if (n == 0) {
            return new int[] {-1, -1};
        }

        // Find first occurrence: first index where nums[i] >= target
        int firstIdx = findFirstTrue(target, true);

        // Check if target exists at firstIdx
        if (firstIdx == -1 || nums[firstIdx] != target) {
            return new int[] {-1, -1};
        }

        // Find last occurrence: first index where nums[i] > target, then subtract 1
        int afterLastIdx = findFirstTrue(target, false);

        int lastIdx;
        if (afterLastIdx == -1) {
            // No element > target exists, last occurrence is at the end
            lastIdx = n - 1;
        } else {
            lastIdx = afterLastIdx - 1;
        }

        return new int[] {firstIdx, lastIdx};
    }

    /**
     * Binary search template to find first index where condition is true.
     * @param target - the target value
     * @param findGreaterOrEqual - if true, finds first nums[i] >= target; if false, finds first nums[i] > target
     */
    private int findFirstTrue(int target, boolean findGreaterOrEqual) {
        int left = 0;
        int right = n - 1;
        int firstTrueIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean feasible = findGreaterOrEqual ? nums[mid] >= target : nums[mid] > target;

            if (feasible) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return firstTrueIndex;
    }

}
