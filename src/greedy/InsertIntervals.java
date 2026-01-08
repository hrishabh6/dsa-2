package greedy;

import java.util.ArrayList;
import java.util.Collections;
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

class Solution {
    public int[] plusOne(int[] digits) {
        //Extract the digit
        //Use long to avoid overflow
        int place = 1;
        long extractNumber = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            extractNumber += (long) digits[i] * place;
            place *= 10;
        }
        //Increment the number
        extractNumber = (long)(extractNumber + 1);

        //Convert back to array
        List<Integer> list = new ArrayList<>();
        while(extractNumber > 0){
            long digit = extractNumber % 10;
            list.add((int)digit);
            extractNumber /= 10;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }


}
