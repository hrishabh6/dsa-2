package SlidingWindow;

public class BinaryArray {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayLessThanEqualToSum(nums, goal) - numSubarrayLessThanEqualToSum(nums, goal - 1);
    }

    private int numSubarrayLessThanEqualToSum(int[] nums, int goal){
        if(goal < 0) return 0;

        int left = 0, right = 0, sum = 0, cnt = 0;

        while(right < nums.length){
            sum += nums[right++];
            while(sum > goal){
                sum -= nums[left++];
            }
            cnt += right - left + 1;
            right++;
        }
        return cnt;

    }


}
