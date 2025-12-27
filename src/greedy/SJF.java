package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

import java.util.*;

class Task {
    int enqueueTime;
    int processingTime;
    int index;

    Task(int e, int p, int i) {
        enqueueTime = e;
        processingTime = p;
        index = i;
    }
}

class SJF {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // Create Task objects with original indices
        Task[] arr = new Task[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        // Sort by enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a.enqueueTime, b.enqueueTime));

        // Min-heap: processing time first, then index
        PriorityQueue<Task> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.processingTime != b.processingTime) {
                        return Integer.compare(a.processingTime, b.processingTime);
                    }
                    return Integer.compare(a.index, b.index);
                }
        );

        int[] ans = new int[n];
        int time = 0;
        int i = 0;
        int ansIndex = 0;

        // Process until all tasks are handled
        while (i < n || !minHeap.isEmpty()) {

            // If CPU is idle, jump time to next task
            if (minHeap.isEmpty() && time < arr[i].enqueueTime) {
                time = arr[i].enqueueTime;
            }

            // Add all available tasks to the heap
            while (i < n && arr[i].enqueueTime <= time) {
                minHeap.offer(arr[i]);
                i++;
            }

            // Execute one task
            Task current = minHeap.poll();
            assert current != null;
            ans[ansIndex++] = current.index;
            time += current.processingTime;
        }

        return ans;
    }
}
