package greedy;

import java.util.Arrays;

public class MinPlatform {

    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int count = 1;
        int maxCount = 1;

        int first = 1;
        int second = 0;

        while (first < n && second < n) {
            if (arr[first] <= dep[second]) {
                count++;
                first++;
                maxCount = Math.max(maxCount, count);
            } else {
                count--;
                second++;
            }
        }

        return maxCount;
    }

}
