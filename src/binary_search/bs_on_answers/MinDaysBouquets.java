package binary_search.bs_on_answers;
/**
 * Problem: MinDaysBouquets
 * Difficulty: Based on folder structure
 */
public class MinDaysBouquets {


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
    }

    // Test cases
    public static void main(String[] args) {
        MinDaysBouquets obj = new MinDaysBouquets();

        // Test case 1
        int[] bloomDay1 = {1, 10, 3, 10, 2};
        int m1 = 3, k1 = 1;
        System.out.println("Test 1: " + obj.minDays(bloomDay1, m1, k1) + " (Expected: 3)");

        // Test case 2
        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2;
        System.out.println("Test 2: " + obj.minDays(bloomDay2, m2, k2) + " (Expected: -1)");

        // Test case 3
        int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};
        int m3 = 2, k3 = 3;
        System.out.println("Test 3: " + obj.minDays(bloomDay3, m3, k3) + " (Expected: 12)");
    }
}
