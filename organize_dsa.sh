#!/bin/bash

# DSA Code Organization Script
# This script organizes your DSA solutions into proper folder structure

echo "🚀 Starting DSA Code Organization..."

# Create main src directory
mkdir -p src

# Create Arrays folder structure
echo "📁 Creating Arrays folder structure..."
mkdir -p "src/arrays/easy"
mkdir -p "src/arrays/medium"
mkdir -p "src/arrays/hard"

# Create Binary Search folder structure
echo "📁 Creating Binary Search folder structure..."
mkdir -p "src/binary_search/bs_on_1d_arrays"
mkdir -p "src/binary_search/bs_on_answers"

echo "✅ Folder structure created successfully!"

# Function to create Java file with package and class structure
create_java_file() {
    local filepath="$1"
    local classname="$2"
    local method_content="$3"
    local test_cases="$4"

    cat > "$filepath" << EOF
package ${filepath%/*};

/**
 * Problem: $classname
 * Difficulty: Based on folder structure
 */
public class $classname {

$method_content

    // Test cases
    public static void main(String[] args) {
        $classname obj = new $classname();
$test_cases
    }
}
EOF
}

echo "📝 Creating Array Easy solutions..."

# Two Sum Problem
create_java_file "src/arrays/easy/TwoSum.java" "TwoSum" "
    /**
     * Return the indices of the two numbers such that they add up to a specific target.
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

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

    /**
     * If array is sorted then we can use two pointers
     * Time Complexity: O(n), Space Complexity: O(1)
     */
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
    }" "
        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = obj.twoSum(nums1, target1);
        System.out.println(\"Test 1: [\" + result1[0] + \", \" + result1[1] + \"]\");

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = obj.twoSum(nums2, target2);
        System.out.println(\"Test 2: [\" + result2[0] + \", \" + result2[1] + \"]\");

        // Test case 3 - sorted array
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result3 = obj.twoSum_sorted(sorted, 17);
        System.out.println(\"Test 3 (sorted): [\" + result3[0] + \", \" + result3[1] + \"]\");"

# Maximum Consecutive Ones
create_java_file "src/arrays/easy/MaxConsecutiveOnes.java" "MaxConsecutiveOnes" "
    /**
     * Find the maximum number of consecutive 1s in the array.
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }" "
        // Test case 1
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        System.out.println(\"Test 1: \" + obj.findMaxConsecutiveOnes(nums1) + \" (Expected: 3)\");

        // Test case 2
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(\"Test 2: \" + obj.findMaxConsecutiveOnes(nums2) + \" (Expected: 2)\");

        // Test case 3
        int[] nums3 = {0, 0, 0};
        System.out.println(\"Test 3: \" + obj.findMaxConsecutiveOnes(nums3) + \" (Expected: 0)\");"

echo "📝 Creating Array Medium solutions..."

# Sort Array of 0s 1s and 2s (Dutch National Flag)
create_java_file "src/arrays/medium/SortColors.java" "SortColors" "
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
    }" "
        // Test case 1
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        obj.sortColors(nums1);
        System.out.print(\"Test 1: \");
        for (int num : nums1) System.out.print(num + \" \");
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 0, 1};
        obj.sortColors(nums2);
        System.out.print(\"Test 2: \");
        for (int num : nums2) System.out.print(num + \" \");
        System.out.println();

        // Test case 3
        int[] nums3 = {0, 0, 2, 1, 1, 0, 2, 2, 1, 0};
        obj.sortColors(nums3);
        System.out.print(\"Test 3: \");
        for (int num : nums3) System.out.print(num + \" \");
        System.out.println();"

# Majority Element
create_java_file "src/arrays/medium/MajorityElement.java" "MajorityElement" "
    /**
     * Boyer-Moore Voting Algorithm to find majority element
     * Time Complexity: O(n), Space Complexity: O(1)
     */
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
        // Verify if candidate is a majority element
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
    }" "
        // Test case 1
        int[] nums1 = {3, 2, 3};
        System.out.println(\"Test 1: \" + obj.majorityElement(nums1) + \" (Expected: 3)\");

        // Test case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(\"Test 2: \" + obj.majorityElement(nums2) + \" (Expected: 2)\");

        // Test case 3
        int[] nums3 = {1, 2, 1, 3, 1, 4, 1, 5, 1, 1, 1, 6, 1, 1, 1, 7};
        System.out.println(\"Test 3: \" + obj.majorityElement(nums3) + \" (Expected: 1)\");"

# Maximum Subarray (Kadane's Algorithm)
create_java_file "src/arrays/medium/MaxSubArray.java" "MaxSubArray" "
    /**
     * Kadane's Algorithm for maximum subarray sum
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            max = Math.max(max, currentSum);
        }
        return max;
    }" "
        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(\"Test 1: \" + obj.maxSubArray(nums1) + \" (Expected: 6)\");

        // Test case 2
        int[] nums2 = {1};
        System.out.println(\"Test 2: \" + obj.maxSubArray(nums2) + \" (Expected: 1)\");

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(\"Test 3: \" + obj.maxSubArray(nums3) + \" (Expected: 23)\");"

# Stock Buy and Sell
create_java_file "src/arrays/medium/BestTimeToBuyStock.java" "BestTimeToBuyStock" "
    /**
     * Maximum profit from buying and selling stock once
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            int currentProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }" "
        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(\"Test 1: \" + obj.maxProfit(prices1) + \" (Expected: 5)\");

        // Test case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(\"Test 2: \" + obj.maxProfit(prices2) + \" (Expected: 0)\");

        // Test case 3
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println(\"Test 3: \" + obj.maxProfit(prices3) + \" (Expected: 4)\");"

# Rearrange Array in Alternating Positive and Negative
create_java_file "src/arrays/medium/RearrangeArray.java" "RearrangeArray" "
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
    }" "
        // Test case 1
        int[] nums1 = {3, 1, -2, -5, 2, -4};
        int[] result1 = obj.rearrangeArray(nums1);
        System.out.print(\"Test 1: \");
        for (int num : result1) System.out.print(num + \" \");
        System.out.println();

        // Test case 2
        int[] nums2 = {-1, 1};
        int[] result2 = obj.rearrangeArray(nums2);
        System.out.print(\"Test 2: \");
        for (int num : result2) System.out.print(num + \" \");
        System.out.println();

        // Test case 3
        int[] nums3 = {1, 2, -3, -1, -2, 3};
        int[] result3 = obj.rearrangeArray(nums3);
        System.out.print(\"Test 3: \");
        for (int num : result3) System.out.print(num + \" \");
        System.out.println();"

# Longest Consecutive Sequence
create_java_file "src/arrays/medium/LongestConsecutiveSequence.java" "LongestConsecutiveSequence" "
    /**
     * Find the longest consecutive sequence in an array
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public int longestConsecutive(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
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
    }" "
        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(\"Test 1: \" + obj.longestConsecutive(nums1) + \" (Expected: 4)\");

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(\"Test 2: \" + obj.longestConsecutive(nums2) + \" (Expected: 9)\");

        // Test case 3
        int[] nums3 = {1, 2, 0, 1};
        System.out.println(\"Test 3: \" + obj.longestConsecutive(nums3) + \" (Expected: 3)\");"

# Set Matrix Zeros
create_java_file "src/arrays/medium/SetMatrixZeros.java" "SetMatrixZeros" "
    /**
     * Set entire row and column to zero if any element is zero
     * Time Complexity: O(m*n), Space Complexity: O(1)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first column should be zero
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Check if first row should be zero
        for(int i = 0; i<n; i++){
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Mark zeros using first row and column
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeros based on marks
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row to zero if needed
        if(firstRowZero){
            for(int i = 0; i < n ; i++){
                matrix[0][i] = 0;
            }
        }

        // Set first column to zero if needed
        if(firstColZero){
            for(int i = 0; i < m ; i++){
                matrix[i][0] = 0;
            }
        }
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + \" \");
            }
            System.out.println();
        }
    }" "
        // Test case 1
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(\"Test 1 - Before:\");
        obj.printMatrix(matrix1);
        obj.setZeroes(matrix1);
        System.out.println(\"After:\");
        obj.printMatrix(matrix1);

        // Test case 2
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println(\"\\nTest 2 - Before:\");
        obj.printMatrix(matrix2);
        obj.setZeroes(matrix2);
        System.out.println(\"After:\");
        obj.printMatrix(matrix2);"

# Spiral Matrix
create_java_file "src/arrays/medium/SpiralMatrix.java" "SpiralMatrix" "
    /**
     * Print matrix in spiral order
     * Time Complexity: O(m*n), Space Complexity: O(1) excluding result
     */
    public java.util.List<Integer> spiralOrder(int[][] matrix) {
        java.util.List<Integer> answer = new java.util.ArrayList<>();
        if(matrix.length == 0) return answer;

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length -1;

        while(top <= bottom && left <= right){
            // Traverse right
            for(int i = left; i <= right; i++){
                answer.add(matrix[top][i]);
            }
            top++;

            // Traverse down
            for(int i = top; i <= bottom; i++){
                answer.add(matrix[i][right]);
            }
            right--;

            // Traverse left (if still valid row)
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse up (if still valid column)
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }
        return answer;
    }" "
        // Test case 1
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        java.util.List<Integer> result1 = obj.spiralOrder(matrix1);
        System.out.println(\"Test 1: \" + result1);

        // Test case 2
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        java.util.List<Integer> result2 = obj.spiralOrder(matrix2);
        System.out.println(\"Test 2: \" + result2);

        // Test case 3
        int[][] matrix3 = {{1}};
        java.util.List<Integer> result3 = obj.spiralOrder(matrix3);
        System.out.println(\"Test 3: \" + result3);"

echo "📝 Creating Array Hard solutions..."

# Three Sum
create_java_file "src/arrays/hard/ThreeSum.java" "ThreeSum" "
    /**
     * Find all unique triplets that sum to zero (Two Pointer Approach)
     * Time Complexity: O(n²), Space Complexity: O(1) excluding result
     */
    public java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
        java.util.List<java.util.List<Integer>> answer = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                } else if(sum < 0){
                    j++;
                } else {
                    answer.add(java.util.Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Skip duplicates
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return answer;
    }" "
        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        java.util.List<java.util.List<Integer>> result1 = obj.threeSum(nums1);
        System.out.println(\"Test 1: \" + result1);

        // Test case 2
        int[] nums2 = {0, 1, 1};
        java.util.List<java.util.List<Integer>> result2 = obj.threeSum(nums2);
        System.out.println(\"Test 2: \" + result2);

        // Test case 3
        int[] nums3 = {0, 0, 0};
        java.util.List<java.util.List<Integer>> result3 = obj.threeSum(nums3);
        System.out.println(\"Test 3: \" + result3);"

# Four Sum
create_java_file "src/arrays/hard/FourSum.java" "FourSum" "
    /**
     * Find all unique quadruplets that sum to target (Two Pointer Approach)
     * Time Complexity: O(n³), Space Complexity: O(1) excluding result
     */
    public java.util.List<java.util.List<Integer>> fourSum(int[] nums, int target) {
        java.util.List<java.util.List<Integer>> answer = new java.util.ArrayList<>();
        int n = nums.length;
        java.util.Arrays.sort(nums);

        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1;
                int high = n-1;
                while(low < high) {
                    long sum = (long)nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target) {
                        answer.add(java.util.Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
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
    }" "
        // Test case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        java.util.List<java.util.List<Integer>> result1 = obj.fourSum(nums1, target1);
        System.out.println(\"Test 1: \" + result1);

        // Test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        java.util.List<java.util.List<Integer>> result2 = obj.fourSum(nums2, target2);
        System.out.println(\"Test 2: \" + result2);

        // Test case 3
        int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target3 = -294967296;
        java.util.List<java.util.List<Integer>> result3 = obj.fourSum(nums3, target3);
        System.out.println(\"Test 3: \" + result3);"

# Merge Two Sorted Arrays
create_java_file "src/arrays/hard/MergeSortedArrays.java" "MergeSortedArrays" "
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
            System.out.print(num + \" \");
        }
        System.out.println();
    }" "
        // Test case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        System.out.println(\"Test 1 - Before merge:\");
        System.out.print(\"nums1: \");
        obj.printArray(java.util.Arrays.copyOf(nums1, 3));
        System.out.print(\"nums2: \");
        obj.printArray(nums2);
        obj.merge(nums1, 3, nums2, 3);
        System.out.print(\"After merge: \");
        obj.printArray(nums1);

        // Test case 2
        int[] nums3 = {1, 0};
        int[] nums4 = {2};
        System.out.println(\"\\nTest 2:\");
        obj.merge(nums3, 1, nums4, 1);
        System.out.print(\"Result: \");
        obj.printArray(nums3);"

echo "📝 Creating Binary Search solutions..."

# Binary Search
create_java_file "src/binary_search/bs_on_1d_arrays/BinarySearch.java" "BinarySearch" "
    /**
     * Classic Binary Search
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }" "
        // Test case 1
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println(\"Test 1: \" + obj.binarySearch(nums1, target1) + \" (Expected: 4)\");

        // Test case 2
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println(\"Test 2: \" + obj.binarySearch(nums2, target2) + \" (Expected: -1)\");

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target3 = 1;
        System.out.println(\"Test 3: \" + obj.binarySearch(nums3, target3) + \" (Expected: 0)\");"

# Search in Rotated Sorted Array
create_java_file "src/binary_search/bs_on_1d_arrays/SearchRotatedArray.java" "SearchRotatedArray" "
    /**
     * Search in Rotated Sorted Array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int search(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == k) return mid;

            // The left half is sorted
            if (arr[mid] >= arr[low]) {
                if(arr[low] <= k && k <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // The right half is sorted
            else {
                if(arr[mid] <= k && k <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }" "
        // Test case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println(\"Test 1: \" + obj.search(nums1, target1) + \" (Expected: 4)\");

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println(\"Test 2: \" + obj.search(nums2, target2) + \" (Expected: -1)\");

        // Test case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println(\"Test 3: \" + obj.search(nums3, target3) + \" (Expected: -1)\");"

# Search in Rotated Sorted Array II
create_java_file "src/binary_search/bs_on_1d_arrays/SearchRotatedArrayII.java" "SearchRotatedArrayII" "
    /**
     * Search in Rotated Sorted Array II (with duplicates)
     * Time Complexity: O(log n) average, O(n) worst case, Space Complexity: O(1)
     */
    public boolean search(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == k) return true;

            // Handle duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Left half is sorted
            if(arr[mid] >= arr[low]){
                if(arr[low] <= k && k <= arr[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else{
                if(arr[mid] <= k && k <= arr[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }" "
        // Test case 1
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println(\"Test 1: \" + obj.search(nums1, target1) + \" (Expected: true)\");

        // Test case 2
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println(\"Test 2: \" + obj.search(nums2, target2) + \" (Expected: false)\");

        // Test case 3
        int[] nums3 = {1, 0, 1, 1, 1};
        int target3 = 0;
        System.out.println(\"Test 3: \" + obj.search(nums3, target3) + \" (Expected: true)\");"

# Find Minimum in Rotated Sorted Array
create_java_file "src/binary_search/bs_on_1d_arrays/FindMinRotatedArray.java" "FindMinRotatedArray" "
    /**
     * Find minimum element in rotated sorted array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;

            // If the search space is fully sorted
            if(arr[low] <= arr[high]){
                ans = Math.min(arr[low], ans);
                break;
            }

            // Left half is sorted
            if(arr[low] <= arr[mid]){
                ans = Math.min(arr[low], ans);
                low = mid + 1;
            } else {
                ans = Math.min(arr[mid], ans);
                high = mid - 1;
            }
        }
        return ans;
    }" "
        // Test case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(\"Test 1: \" + obj.findMin(nums1) + \" (Expected: 1)\");

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(\"Test 2: \" + obj.findMin(nums2) + \" (Expected: 0)\");

        // Test case 3
        int[] nums3 = {11, 13, 15, 17};
        System.out.println(\"Test 3: \" + obj.findMin(nums3) + \" (Expected: 11)\");"

# Single Element in Sorted Array
create_java_file "src/binary_search/bs_on_1d_arrays/SingleElementSorted.java" "SingleElementSorted" "
    /**
     * Find single element in sorted array where every other element appears twice
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];

        // Check for first element
        if(arr[0] != arr[1]) return arr[0];

        // Check for last element
        if(arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1, high = n - 2;
        while(low <= high){
            int mid = (low + high) / 2;

            // Return element if found
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
                return arr[mid];
            }

            // Check if we are in left half
            if((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
               (mid % 2 == 0 && arr[mid] == arr[mid + 1])){
                // Eliminate the left half as element exists on right half
                low = mid + 1;
            }
            // else we are in right half
            else {
                high = mid - 1;
            }
        }
        return -1;
    }" "
        // Test case 1
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(\"Test 1: \" + obj.singleNonDuplicate(nums1) + \" (Expected: 2)\");

        // Test case 2
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(\"Test 2: \" + obj.singleNonDuplicate(nums2) + \" (Expected: 10)\");

        // Test case 3
        int[] nums3 = {1, 1, 2, 2, 3};
        System.out.println(\"Test 3: \" + obj.singleNonDuplicate(nums3) + \" (Expected: 3)\");"

# Find Peak Element
create_java_file "src/binary_search/bs_on_1d_arrays/FindPeakElement.java" "FindPeakElement" "
    /**
     * Find peak element in array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        int low = 1, high = n - 2;
        while(low <= high){
            int mid = (low + high) / 2;

            // If peak found return it
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) return mid;

            // If on the increasing curve, peak will be on right so eliminate left
            else if(arr[mid] > arr[mid-1]) low = mid + 1;

            // If on decreasing curve, peak will be on left
            else high = mid - 1;
        }
        return -1;
    }" "
        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(\"Test 1: \" + obj.findPeakElement(nums1) + \" (Expected: 2)\");

        // Test case 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(\"Test 2: \" + obj.findPeakElement(nums2) + \" (Expected: 1 or 5)\");

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(\"Test 3: \" + obj.findPeakElement(nums3) + \" (Expected: 4)\");"

echo "📝 Creating Binary Search on Answers solutions..."

# Square Root
create_java_file "src/binary_search/bs_on_answers/SquareRoot.java" "SquareRoot" "
    /**
     * Find square root of a number using binary search
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
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
    }" "
        // Test case 1
        int x1 = 4;
        System.out.println(\"Test 1: sqrt(\" + x1 + \") = \" + obj.mySqrt(x1) + \" (Expected: 2)\");

        // Test case 2
        int x2 = 8;
        System.out.println(\"Test 2: sqrt(\" + x2 + \") = \" + obj.mySqrt(x2) + \" (Expected: 2)\");

        // Test case 3
        int x3 = 16;
        System.out.println(\"Test 3: sqrt(\" + x3 + \") = \" + obj.mySqrt(x3) + \" (Expected: 4)\");"

# Koko Eating Bananas
create_java_file "src/binary_search/bs_on_answers/KokoEatingBananas.java" "KokoEatingBananas" "
    /**
     * Koko Eating Bananas - Find minimum eating speed
     * Time Complexity: O(n * log(max(piles))), Space Complexity: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findLargest(piles);
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high) / 2;
            long val = computeHours(piles, mid);
            if(val <= h){
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findLargest(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            max = Math.max(i, max);
        }
        return max;
    }

    private long computeHours(int[] arr, int k) {
        long hours = 0;
        for (int i : arr) {
            hours += (i + k - 1) / k; // Ceiling division
        }
        return hours;
    }" "
        // Test case 1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println(\"Test 1: \" + obj.minEatingSpeed(piles1, h1) + \" (Expected: 4)\");

        // Test case 2
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(\"Test 2: \" + obj.minEatingSpeed(piles2, h2) + \" (Expected: 30)\");

        // Test case 3
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(\"Test 3: \" + obj.minEatingSpeed(piles3, h3) + \" (Expected: 23)\");"

# Minimum Days to Make Bouquets
create_java_file "src/binary_search/bs_on_answers/MinDaysBouquets.java" "MinDaysBouquets" "
    /**
     * Minimum number of days to make m bouquets
     * Time Complexity: O(n * log(max(bloomDay))), Space Complexity: O(1)
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1, high = 0;
        for(int day : bloomDay) high = Math.max(high, day);

        while(low < high){
            int mid = low + (high - low) / 2;
            if(canMakeBouquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day){
        int consecutiveFlowers = 0;
        int bouquets = 0;

        for(int bloom : bloomDay){
            if(bloom <= day){
                consecutiveFlowers++;
                if(consecutiveFlowers == k){
                    bouquets++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }
        return bouquets >= m;
    }" "
        // Test case 1
        int[] bloomDay1 = {1, 10, 3, 10, 2};
        int m1 = 3, k1 = 1;
        System.out.println(\"Test 1: \" + obj.minDays(bloomDay1, m1, k1) + \" (Expected: 3)\");

        // Test case 2
        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2;
        System.out.println(\"Test 2: \" + obj.minDays(bloomDay2, m2, k2) + \" (Expected: -1)\");

        // Test case 3
        int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};
        int m3 = 2, k3 = 3;
        System.out.println(\"Test 3: \" + obj.minDays(bloomDay3, m3, k3) + \" (Expected: 12)\");"

# Smallest Divisor
create_java_file "src/binary_search/bs_on_answers/SmallestDivisor.java" "SmallestDivisor" "
    /**
     * Find the smallest divisor given a threshold
     * Time Complexity: O(n * log(max(nums))), Space Complexity: O(1)
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = findMax(nums);
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isDivisorValid(nums, threshold, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Utility function to check if divisor crosses threshold
    private boolean isDivisorValid(int[] arr, int threshold, int divisor){
        int sum = 0;
        for(int num : arr){
            sum += (num + divisor - 1) / divisor; // Ceiling division
            if(sum > threshold) return false; // Early exit
        }
        return true;
    }

    private int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr) max = Math.max(max, num);
        return max;
    }" "
        // Test case 1
        int[] nums1 = {1, 2, 5, 9};
        int threshold1 = 6;
        System.out.println(\"Test 1: \" + obj.smallestDivisor(nums1, threshold1) + \" (Expected: 5)\");

        // Test case 2
        int[] nums2 = {44, 22, 33, 11, 1};
        int threshold2 = 5;
        System.out.println(\"Test 2: \" + obj.smallestDivisor(nums2, threshold2) + \" (Expected: 44)\");

        // Test case 3
        int[] nums3 = {2, 3, 5, 7, 11};
        int threshold3 = 11;
        System.out.println(\"Test 3: \" + obj.smallestDivisor(nums3, threshold3) + \" (Expected: 3)\");"

# Capacity to Ship Packages
create_java_file "src/binary_search/bs_on_answers/ShipPackages.java" "ShipPackages" "
    /**
     * Capacity to ship packages within D days
     * Time Complexity: O(n * log(sum - max)), Space Complexity: O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        int[] sumAndMax = getSumAndMax(weights);
        int high = sumAndMax[0]; // total sum of weights
        int low = sumAndMax[1];  // max weight (at least this much capacity needed)
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            // If it can carry, try smaller capacity
            if(canShipWithCapacity(weights, mid, days)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Calculate sum and max of array
    private int[] getSumAndMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{0, 0};
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        return new int[]{sum, max};
    }

    // Validator function to check if ship can carry weight within D days
    private boolean canShipWithCapacity(int[] arr, int weightCapacity, int days){
        int daysUsed = 1; // start with day 1
        int currentLoad = 0;

        for(int weight : arr){
            if(currentLoad + weight > weightCapacity){
                // need a new day
                daysUsed++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }

            // Exit early if days exceed allowed
            if(daysUsed > days) return false;
        }
        return true;
    }" "
        // Test case 1
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days1 = 5;
        System.out.println(\"Test 1: \" + obj.shipWithinDays(weights1, days1) + \" (Expected: 15)\");

        // Test case 2
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3;
        System.out.println(\"Test 2: \" + obj.shipWithinDays(weights2, days2) + \" (Expected: 6)\");

        // Test case 3
        int[] weights3 = {1, 2, 3, 1, 1};
        int days3 = 4;
        System.out.println(\"Test 3: \" + obj.shipWithinDays(weights3, days3) + \" (Expected: 3)\");

echo "🎉 All files created successfully!"
echo ""
echo "📊 Summary:"
echo "├── src/"
echo "│   ├── arrays/"
echo "│   │   ├── easy/ \(2 problems\)"
echo "│   │   │   ├── TwoSum.java"
echo "│   │   │   └── MaxConsecutiveOnes.java"
echo "│   │   ├── medium/ \(8 problems\)"
echo "│   │   │   ├── SortColors.java"
echo "│   │   │   ├── MajorityElement.java"
echo "│   │   │   ├── MaxSubArray.java"
echo "│   │   │   ├── BestTimeToBuyStock.java"
echo "│   │   │   ├── RearrangeArray.java"
echo "│   │   │   ├── LongestConsecutiveSequence.java"
echo "│   │   │   ├── SetMatrixZeros.java"
echo "│   │   │   └── SpiralMatrix.java"
echo "│   │   └── hard/ \(3 problems\)"
echo "│   │       ├── ThreeSum.java"
echo "│   │       ├── FourSum.java"
echo "│   │       └── MergeSortedArrays.java"
echo "│   └── binary_search/"
echo "│       ├── bs_on_1d_arrays/ \(6 problems\)"
echo "│       │   ├── BinarySearch.java"
echo "│       │   ├── SearchRotatedArray.java"
echo "│       │   ├── SearchRotatedArrayII.java"
echo "│       │   ├── FindMinRotatedArray.java"
echo "│       │   ├── SingleElementSorted.java"
echo "│       │   └── FindPeakElement.java"
echo "│       └── bs_on_answers/ \(5 problems\)"
echo "│           ├── SquareRoot.java"
echo "│           ├── KokoEatingBananas.java"
echo "│           ├── MinDaysBouquets.java"
echo "│           ├── SmallestDivisor.java"
echo "│           └── ShipPackages.java"
echo ""
echo "✅ Total: 24 DSA problems organized with proper folder structure"
echo "✅ Each file contains:"
echo "   - Clean, documented code from your original solutions"
echo "   - Time and Space complexity analysis"
echo "   - 2-3 comprehensive test cases"
echo "   - Proper Java class structure with packages"
echo ""
echo "🚀 Your DSA practice is now properly organized!"
echo "💡 To run any solution: javac src/category/difficulty/ClassName.java && java src.category.difficulty.ClassName"
