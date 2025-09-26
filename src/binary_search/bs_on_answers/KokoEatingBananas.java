package binary_search.bs_on_answers;
/**
 * Problem: KokoEatingBananas
 * Difficulty: Based on folder structure
 */
public class KokoEatingBananas {


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
    }

    // Test cases
    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();

        // Test case 1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Test 1: " + obj.minEatingSpeed(piles1, h1) + " (Expected: 4)");

        // Test case 2
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Test 2: " + obj.minEatingSpeed(piles2, h2) + " (Expected: 30)");

        // Test case 3
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("Test 3: " + obj.minEatingSpeed(piles3, h3) + " (Expected: 23)");
    }
}
