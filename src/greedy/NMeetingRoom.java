package greedy;

import java.util.Arrays;

class Data {
    int start, end;
}

public class NMeetingRoom {

    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        Data[] arr = new Data[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Data();
            arr[i].start = start[i];
            arr[i].end = end[i];
        }
        Arrays.sort(arr, (a, b) -> a.end - b.end);
        int cnt  = 1;
        int freeTime = arr[0].end;

        for(int i = 1; i < n; i++){
            if (arr[i].start > freeTime){
                freeTime = arr[i].end;
                cnt++;
            }
        }
        return cnt;
    }



}
