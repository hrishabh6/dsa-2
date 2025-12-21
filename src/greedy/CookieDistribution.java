package greedy;

import java.util.Arrays;

public class CookieDistribution {

    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        int l = 0, r = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l < m && r < n){
            if (g[r] <= s[l]){
                r++;
            }
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(new CookieDistribution().findContentChildren(g, s));
    }

}
