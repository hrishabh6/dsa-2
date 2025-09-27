package binary_search.bs_on_answers;

public class AggressiveCows {

    public static int[] getMinAndMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        return new int[]{min, max};
    }

    private boolean canWePlace(int[] stalls, int k, int mid){
        int currentCount = 0;
        int last = stalls[0];
        for(int cows : stalls){
            if(cows - last >= mid){
                currentCount++;
                last = cows;
            }
            if(currentCount >= k) return true;
        }
        return false;

    }

    public int aggressiveCows(int[] stalls, int k) {
        // code here
        int[] temp = getMinAndMax(stalls);
        int low = temp[0];
        int high = temp[1];
        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(canWePlace(stalls, k, mid)){
                ans = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return ans;

    }
}
