package greedy;


import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencing {
        //Simple implementation but will give a TLE
//    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
//
//        Integer[] idx = new Integer[profit.length];
//        for (int i = 0; i < idx.length; i++) idx[i] = i;
//
//        Arrays.sort(idx, (a, b) -> profit[b] - profit[a]);
//
//        int[] sortedProfit = new int[profit.length];
//        int[] sortedDeadline = new int[deadline.length];
//
//        for (int i = 0; i < idx.length; i++) {
//            sortedProfit[i]   = profit[idx[i]];
//            sortedDeadline[i] = deadline[idx[i]];
//        }
//
//        int maxDeadline = 0;
//        for (int d : sortedDeadline) {
//            maxDeadline = Math.max(maxDeadline, d);
//        }
//
//        int[] slot = new int[maxDeadline];
//        Arrays.fill(slot, -1);
//
//        int totalProfit = 0, count = 0;
//
//        for (int i = 0; i < profit.length; i++) {
//            for (int j = sortedDeadline[i] - 1; j >= 0; j--) {
//                if (slot[j] == -1) {
//                    slot[j] = 1;
//                    count++;
//                    totalProfit += sortedProfit[i];
//                    break;
//                }
//            }
//        }
//
//        ArrayList<Integer> ans = new ArrayList<>();
//        ans.add(count);
//        ans.add(totalProfit);
//        return ans;
//    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = profit.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> profit[b] - profit[a]);

        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) parent[i] = i;

        int totalProfit = 0, count = 0;

        for (int id : idx) {
            int availableSlot = find(deadline[id], parent);
            if (availableSlot > 0) {
                union(availableSlot, availableSlot - 1, parent);
                count++;
                totalProfit += profit[id];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }

    private int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }

    private void union(int u, int v, int[] parent) {
        parent[u] = v;
    }


}


