package binary_search.bs_on_answers;

//Leetcode Problem 1011. Ship in D Days
public class ShipPackagesInDDays {
    //Sum and max funtion for arr
    public static int[] getSumAndMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{0,0};
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

    //Validator function to check if ship can carry weight within D days
    private boolean validate(int[] arr, int weightCapacity, int days){
        int daysUsed = 1; // start with day 1
        int currentLoad = 0;

        for(int weight : arr){
            // Note: Since 'low' is initialized to the max weight, we don't need to check
            // if 'weight > weightCapacity' as it will always be false.
            // If the current package exceeds the remaining capacity for the day
            if(currentLoad + weight > weightCapacity){
                // need a new day
                daysUsed++;
                currentLoad = 0; // reset load for the new day
            }
            currentLoad += weight;

            //Exit early if days exceed allowed
            if(daysUsed > days) return false;
        }
        return true;
    }

    //My intution : The search space could be [maxElement(arr), sum(arr)]
    public int shipWithinDays(int[] weights, int days) {
        int[] temp = getSumAndMax(weights);
        int high = temp[0]; // total sum of weights
        int low = temp[1];  // max weight (at least this much capacity needed)
        int ans = -1;

        // This is a correct implementation of binary search for the minimum capacity
        while(low <= high){
            int mid = low + (high - low)/2;

            //If it can carry (validate returns true), try a smaller capacity (search left)
            if(validate(weights, mid, days)){
                ans = mid;
                high =  mid - 1;
            } else { // Capacity is too small, need a larger one (search right)
                low = mid + 1;
            }
        }
        return ans;
    }

    // Test cases within main function
    public static void main(String[] args) {
        ShipPackagesInDDays solution = new ShipPackagesInDDays();

        // --- Test Case 1: Example from LeetCode problem description ---
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days1 = 5;
        // Expected Output: 15
        // Explanation: A capacity of 15 is the minimum.
        // Day 1: 1, 2, 3, 4, 5 (Sum=15)
        // Day 2: 6, 7 (Sum=13)
        // Day 3: 8 (Sum=8)
        // Day 4: 9 (Sum=9)
        // Day 5: 10 (Sum=10)
        int result1 = solution.shipWithinDays(weights1, days1);
        System.out.println("--- Test Case 1 ---");
        System.out.println("Weights: " + java.util.Arrays.toString(weights1));
        System.out.println("Days: " + days1);
        System.out.println("Minimum Capacity: " + result1);
        System.out.println("Expected: 15\n");
        //
        System.out.println("--------------------\n");


        // --- Test Case 2: Another Example from LeetCode ---
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3;
        // Expected Output: 6
        // Explanation: A capacity of 6 is the minimum.
        // Day 1: 3, 2, 1 (Sum=6) OR 3, 2 (Sum=5)
        // Day 2: 2, 4 (Sum=6) OR 2, 4 (Sum=6)
        // Day 3: 4 (Sum=4) OR 1, 4 (Sum=5)
        // The groups are: (3, 2, 1), (2, 4), (4) - Max Load: 6
        int result2 = solution.shipWithinDays(weights2, days2);
        System.out.println("--- Test Case 2 ---");
        System.out.println("Weights: " + java.util.Arrays.toString(weights2));
        System.out.println("Days: " + days2);
        System.out.println("Minimum Capacity: " + result2);
        System.out.println("Expected: 6\n");
        System.out.println("--------------------\n");


        // --- Test Case 3: Days = 1 (Capacity must be total sum) ---
        int[] weights3 = {1, 2, 3};
        int days3 = 1;
        // Expected Output: 6 (1+2+3)
        int result3 = solution.shipWithinDays(weights3, days3);
        System.out.println("--- Test Case 3 ---");
        System.out.println("Weights: " + java.util.Arrays.toString(weights3));
        System.out.println("Days: " + days3);
        System.out.println("Minimum Capacity: " + result3);
        System.out.println("Expected: 6\n");
        System.out.println("--------------------\n");


        // --- Test Case 4: Days = length of weights (Capacity must be max weight) ---
        int[] weights4 = {10, 5, 8, 2};
        int days4 = 4;
        // Expected Output: 10 (max weight)
        int result4 = solution.shipWithinDays(weights4, days4);
        System.out.println("--- Test Case 4 ---");
        System.out.println("Weights: " + java.util.Arrays.toString(weights4));
        System.out.println("Days: " + days4);
        System.out.println("Minimum Capacity: " + result4);
        System.out.println("Expected: 10\n");
        System.out.println("--------------------\n");


        // --- Test Case 5: Simple case, medium days ---
        int[] weights5 = {1, 5, 2, 4};
        int days5 = 2;
        // Expected Output: 7 (Groups: (1, 5, 2) Sum=8, Too big; (1, 5) Sum=6, Day 1: (1, 5), Day 2: (2, 4) - Max Load=6.
        // Try 7: Day 1: (1, 5, 1) Sum=7; Day 2: (4) - No 1 left.
        // Try 7: Day 1: (1, 5) Sum=6; Day 2: (2, 4) Sum=6. Not optimal.
        // Capacity 7: Day 1: (1, 5), (2) -> 8 > 7, (1, 5) Sum=6. Day 2: (2, 4) Sum=6.
        // Capacity 7: Day 1: 1, 5, 2 (8>7, not allowed). Day 1: 1, 5 (6). Day 2: 2, 4 (6). Days Used: 2. Valid.
        // Can we do 6? Day 1: 1, 5 (6). Day 2: 2, 4 (6). Days Used: 2. Valid. Ans=6.
        int result5 = solution.shipWithinDays(weights5, days5);
        System.out.println("--- Test Case 5 ---");
        System.out.println("Weights: " + java.util.Arrays.toString(weights5));
        System.out.println("Days: " + days5);
        System.out.println("Minimum Capacity: " + result5);
        System.out.println("Expected: 6\n");
        System.out.println("--------------------\n");
    }
}
/*
Expected Output when running the main function:

--- Test Case 1 ---
Weights: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Days: 5
Minimum Capacity: 15
Expected: 15

--------------------

--- Test Case 2 ---
Weights: [3, 2, 2, 4, 1, 4]
Days: 3
Minimum Capacity: 6
Expected: 6

--------------------

--- Test Case 3 ---
Weights: [1, 2, 3]
Days: 1
Minimum Capacity: 6
Expected: 6

--------------------

--- Test Case 4 ---
Weights: [10, 5, 8, 2]
Days: 4
Minimum Capacity: 10
Expected: 10

--------------------

--- Test Case 5 ---
Weights: [1, 5, 2, 4]
Days: 2
Minimum Capacity: 6
Expected: 6

--------------------
*/