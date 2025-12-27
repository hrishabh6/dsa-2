package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        if(intervals.length == 0) return result.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];

        for(int[] interval : intervals){
            if(interval[0] <= end){
                end = Math.max(end, interval[1]);
            } else {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }

}
