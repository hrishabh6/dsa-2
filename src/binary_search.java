public class binary_search {

    //Classic Binary Search
    public int binarySearch(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

    //Search in Rotated Sorted Array
    public int search(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == k) return mid;
            //The left half is sorted
            if (arr[mid] >= arr[low]) {
                if(arr[mid] <= k && k <= arr[high]){
                    low = mid+1;
                } else {
                    high = mid - 1;
                }
            }
            //The right half is sorted
            else {
                if(arr[low] <= k && k <= arr[mid]){
                    high = mid-1;

                } else {
                    low = mid+1;
                }
            }

        }
        return -1;
    }

    //Search in Rotated Sorted Array II
    public boolean search2(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == k) return true;

            //Just insert 1 condition
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low+1;
                high = high-1;
                continue;
            }

            //Left half is sorted
            if(arr[mid] >= arr[low]){
                if(arr[low] <= k && k <= arr[mid]){
                    high = mid-1;

                } else {
                    low = mid+1;
                }
            }
            //RIght half is sorteed
            else{
                if(arr[mid] <= k && k <= arr[high]){
                    low = mid+1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public int findMin(int[] arr) {
        int low = 0, high = arr.length -1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low+ high)/2;

            //If the search space is fully sorted
            if(arr[low] <= arr[high]){
                ans = Integer.min(arr[low], ans);
                break;
            }

            //Left half is sorted
            if(arr[low] <= arr[mid]){
                ans = Integer.min(arr[low], ans);
                low = mid+1;
            } else {
                ans = Integer.min(arr[mid], ans);
                high = mid-1;
            }
        }
        return ans;
    }

    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        //Check for first element
        if(arr[0] != arr[1]) return arr[0];

        //Check for last element
        if(arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;

            //Return element if found
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
                return arr[mid];
            }

            //Check if we are in left half
            if((mid % 2 == 1 && arr[mid] == arr[mid - 1 ]) || (mid%2 == 0 && arr[mid] == arr[mid+1])){
                //Eliminate the left half as element exist on right half
                low = mid+1;
            }
            //else we are in right half
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        int low = 1, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;

            //If peak found return it
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) return mid;

                //If on the increasing curve, peak will be on right so eliminate left
            else if(arr[mid] > arr[mid-1]) low = mid+1;

                //If on decreasing curve, peak will be on left
            else if(arr[mid] > arr[mid+1]) high = mid-1;

                //For multiple peaks, if mid is at crust move either side
            else {low = mid+1;}
        }
        return -1;
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int low = 1, high = x / 2, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long val = (long) mid * mid; // avoid overflow

            if (val == x) {
                return mid;  // exact square root
            } else if (val < x) {
                ans = mid;   // candidate
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,8,7,6,89,9};
        int[] arr2 = {7, 1, 5, 3, 6, 4};
        int[] sorted_arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr4 = {0,2,2,1,0,0,0,2,1,0,2,2,1,1,1,1,0,0,0,2,1,2,1,2,1,2,1,2};
        int[] arr5 = {1,2,1,3,1,4,1,5,1,1,1,6,1,1,1,7};
        int[] arr6 = {-2,1,-3,4,-1,2,1,-5,4};
        array_med obj = new array_med();

//        returnable results

//        int[] result = obj.twoSum(arr1, 13);
//        int [] result = obj.twoSum_sorted(sorted_arr, 17);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

//        returnable but not itratable
//
//        int result = obj.maxProfit(arr2);
//        System.out.println(result);

//        non returnable results

//        obj.sortArrayOf0s1s2s(arr4);
//
//        for (int i = 0; i < arr4.length; i++) {
//            System.out.print(arr4[i] + ", ");
//        }
    }
}
