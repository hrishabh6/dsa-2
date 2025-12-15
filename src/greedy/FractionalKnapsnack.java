package greedy;

import java.util.Arrays;

public class FractionalKnapsnack {

    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {

            // Sort by units per box descending
            Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

            int totalUnits = 0;

            for (int[] boxType : boxTypes) {
                if (truckSize == 0) break;

                int boxesTaken = Math.min(boxType[0], truckSize);
                totalUnits += boxesTaken * boxType[1];
                truckSize -= boxesTaken;
            }

            return totalUnits;
        }
    }


}
