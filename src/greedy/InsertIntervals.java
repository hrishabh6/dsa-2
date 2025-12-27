package greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int length = intervals.length;

        List<int[]> resultant = new ArrayList<>();
        if(length == 0) return new int[][]{newInterval};
        int i = 0;
        //Left half
        while(i < length && intervals[i][1] < newInterval[0]){
            resultant.add(intervals[i]);
            i++;
        }

        while(i < length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        resultant.add(newInterval);

        while(i < length){
            resultant.add(intervals[i]);
            i++;
        }

        return resultant.toArray(new int[resultant.size()][]);

    }


}
