import jdk.jshell.Snippet;

import java.util.*;

public class array_med {

    //Return the indices of the two numbers such that they add up to a specific target.
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap <Integer, Integer> map = new HashMap<>();

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

    //if array is sorted then we can use two pointers to return the indices of the two numbers such that they add up to a specific target.
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

    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int [] arr, int i, int j) {
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    //Dutch National Flag Problem
    public void sortArrayOf0s1s2s(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        //verify if a candidate is a majority element
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    //maximum subarray sum (Kadane's Algorithm)'
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            max = Math.max(max, currentSum);
        }
        return max;
    }

    //Maximizing the profit
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            int currentProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }

    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
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

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longestSequence = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentNumber = num;
                int currentStreak = 1;
                while(set.contains(currentNumber+1)){
                    currentNumber++;
                    currentStreak++;
                }
                longestSequence = Math.max(longestSequence, currentStreak);
            }
        }
        return longestSequence;
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        //marking first row
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColZero = true;
                break;
            }
        }

        //marking first col
        for(int i = 0; i<n; i++){
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        //Marking the other numbers
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //set others to zero
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //set the first row to zero
        if(firstRowZero){
            for(int i = 0; i < n ; i++){
                matrix[0][i] = 0;
            }
        }

        //set the first col to zero
        if(firstColZero){
            for(int i = 0; i < m ; i++){
                matrix[i][0] = 0;
            }
        }

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if(matrix.length == 0) return answer;

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length -1;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                answer.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                answer.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }
        return answer;

    }
    //Using Hashmap
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> finalSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int thirdNumber = -(nums[i] + nums[j]);
                if (set.contains(thirdNumber)) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], thirdNumber);
                    Collections.sort(list); // Important to avoid duplicates
                    finalSet.add(list);
                }
                set.add(nums[j]); // Track the actual seen number
            }
        }

        return new ArrayList<>(finalSet);
    }

    //Two Pointer for threeSUm
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j =  i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum =  nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                } else if(sum < 0){
                    j++;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    answer.add(list);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;

                }
            }
        }
        return answer;
    }

    //Four sum with set
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> store = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                Set<Long> temp = new HashSet<>();
                for(int k = j+1; k < n; k++) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k];
                    long fourth = (long)target - sum;
                    if(temp.contains(fourth)) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);
                        Collections.sort(list);
                        store.add(list);
                    }
                    temp.add((long)nums[k]);
                }
            }
        }

        return new ArrayList<>(store);
    }

    //Four sum with two pointers
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1;
                int high = n-1;
                while(low < high) {
                    long sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        Collections.sort(list);
                        answer.add(list);
                        low++;
                        high--;
                        while(low < high && nums[low] == nums[low-1]) low++;
                        while(low < high && nums[high] == nums[high+1]) high--;
                    }
                    else if(sum < target) low++;
                    else high--;
                }
            }
        }
        return answer;
    }

    //Merge two sorted array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;
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

        Arrays.sort(nums1, 0, m); // sort only the first m slots
        Arrays.sort(nums2);
        for (int k = 0; k < n; k++) {
            nums1[m + k] = nums2[k];
        }
    }

    //merge two sorted array with Gap method

    //helper method swap
    public void swapIfGreater(int[] nums, int[] nums2, int i, int j) {
        if(nums[i] > nums2[j]) {
            int tmp = nums[i];
            nums[i] = nums2[j];
            nums2[j] = tmp;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int length = m+n;
        int gap = (length/2) + (length%2);
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < length){
                //Arr1 and arr2
                if(left < n && right >= n){
                    swapIfGreater(nums1, nums2, left, right - n);
                }
                //Both in arr 1
                else if (left >= n) {
                    swapIfGreater(nums1, nums2, left - n , right - n);
                }
                else {
                    swapIfGreater(nums1, nums2, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);  // ceil(gap/2)

        }

        for(int k = 0; k < n; k++){
            nums1[m + k] = nums2[k];
        }
    }

    //find missing and repeating numbers using mathematics
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        long n = arr.length;

        long Sn = (n * (n+1))/2;
        long S2n = (n * (n+1) * (2*n+1)) /6;
        long sum = 0, squareSum = 0;
        for (int j : arr) {
            sum += j;
            squareSum += (long) j * (long) j;
        }
        long val1 = sum - Sn; //x-y
        long val2 = squareSum - S2n;
        val2 = val2/val1; //gives us x + y
        long x = (val1 + val2)/2;
        long y = x - val1;
        return new ArrayList<>(Arrays.asList((int) x, (int) y ));
    }

    //Count the inversions using merge sort technique
    //Merge function
    int merge(int[] arr, int l, int m, int r) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int i = l, j = m + 1, k = l;
        //Storing the elements in the list
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                list.add(arr[i]);
                i++;
            } else {
                list.add(arr[j]);
                count += (m - i + 1);
                j++;
            }
        }
        //If elements left in left array
        while (i <= m) {
            list.add(arr[i]);
            i++;
        }

        //If elements left in right array
        while (j <= r) {
            list.add(arr[j]);
            j++;
        }

        //Copying the elements from list to array
        for (int x : list) {
            arr[k++] = x;
        }
        return count;
    }

    int mergeSort(int[] arr, int l, int r) {
        int count = 0;
        if (l >= r) {
            return count;
        }
        int mid = (l + r)/2;
        //call the function for left subarray
        count += mergeSort(arr, l, mid);
        //call the function for right subarray
        count += mergeSort(arr, mid + 1, r);
        //now merge the two subarrays and count the inversions
        count += merge(arr, l, mid, r);

        return count;
    }

    int inversionCount(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }


    //Count no of Reverse pairs in an array
    private static void merge2(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    static long countPairs(int[] arr, int low, int mid, int high){
        int right = mid + 1;
        long count = 0;
        for(int i = low; i <= mid; i++){
           while(right <= high && arr[i] > 2*arr[right]){
               right++;
           }
           count += (right - (mid + 1));
           
        }
        return count;
    }

    public static long mergeSort2(int[] arr, int low, int high) {
        long count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2 ;
        count += mergeSort2(arr, low, mid);  // left half
        count += mergeSort2(arr, mid + 1, high); // right half
        count += countPairs(arr, low, mid, high);
        merge2(arr, low, mid, high);  // merging sorted halves
        return count;
    }

    public int reversePairs(int[] nums) {
        return (int) mergeSort2(nums, 0, nums.length - 1);

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
//        int result = obj.majorityElement(arr5);
//        int result = obj.maxSubArray(arr6);
        int result = obj.maxProfit(arr2);
        System.out.println(result);

//        non returnable results

//        obj.sortArrayOf0s1s2s(arr4);
//
//        for (int i = 0; i < arr4.length; i++) {
//            System.out.print(arr4[i] + ", ");
//         }


    }

}
