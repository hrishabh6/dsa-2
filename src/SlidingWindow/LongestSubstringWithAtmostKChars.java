package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKChars {

    public int longestKSubstr(String s, int k) {
        int l = 0, r = 0;
        int maxSum = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < s.length()){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k){
                char d = s.charAt(l);
                map.put(d, map.get(d) - 1);
                if(map.get(d) == 0) map.remove(d);
                l++;
            }
            maxSum = Math.max(maxSum, r - l + 1);
            r++;
        }
        return maxSum;

    }

}
