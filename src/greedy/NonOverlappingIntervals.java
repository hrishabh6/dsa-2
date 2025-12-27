package greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        //Sort the array accordint to the end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int lastEndTime = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            // If current interval overlaps with previous
            if (intervals[i][0] < lastEndTime) {
                // Increment count to remove this interval
                count++;
            } else {
                // Update previous end time
                lastEndTime = intervals[i][1];
            }
        }
        return count;

    }

}
