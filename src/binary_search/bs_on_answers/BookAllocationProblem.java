package binary_search.bs_on_answers;

import java.util.Arrays;

public class BookAllocationProblem {

    //Similar problem on leetcode is 410. Split Array Largest Sum
    //PS : Given an integer array nums and an integer k, split nums into k non-empty subarrays
    // such that the largest sum of any subarray is minimized.
//    Example 1:
//
//    Input: nums = [7,2,5,10,8], k = 2
//    Output: 18
//    Explanation: There are four ways to split nums into two subarrays.
//    The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

    private int validate(int[] arr, int mid){
        int count = 1;
        long subarraySum = 0;

        for(int i = 0; i < arr.length; i++){
            if(subarraySum + arr[i] <= mid ){
                subarraySum += arr[i];
            } else {
                count += 1;
                subarraySum = arr[i];
            }
        }
        return count;
    }

    public int splitArray(int[] nums, int k) {
        if (k > nums.length) return -1;
        int high = Arrays.stream(nums).sum();
        int low = Arrays.stream(nums).max().getAsInt();
        while(low <= high){
            int mid = low + (high - low)/2;
            if(validate(nums, mid) > k){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}
