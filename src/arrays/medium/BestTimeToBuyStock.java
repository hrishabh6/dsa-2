package arrays.medium;
/**
 * Problem: BestTimeToBuyStock
 * Difficulty: Based on folder structure
 */
public class BestTimeToBuyStock {


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
    }

    // Test cases
    public static void main(String[] args) {
        BestTimeToBuyStock obj = new BestTimeToBuyStock();

        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + obj.maxProfit(prices1) + " (Expected: 5)");

        // Test case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test 2: " + obj.maxProfit(prices2) + " (Expected: 0)");

        // Test case 3
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + obj.maxProfit(prices3) + " (Expected: 4)");
    }
}
