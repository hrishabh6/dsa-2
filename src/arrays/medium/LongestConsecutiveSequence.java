package arrays.medium;

/**
 * Problem: LongestConsecutiveSequence
 * Difficulty: Based on folder structure
 */
public class LongestConsecutiveSequence {


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
    }

    // Test cases
    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test 1: " + obj.longestConsecutive(nums1) + " (Expected: 4)");

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test 2: " + obj.longestConsecutive(nums2) + " (Expected: 9)");

        // Test case 3
        int[] nums3 = {1, 2, 0, 1};
        System.out.println("Test 3: " + obj.longestConsecutive(nums3) + " (Expected: 3)");
    }
}
