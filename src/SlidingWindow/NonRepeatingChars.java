package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0, r = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(map.get(s.charAt(i)) + 1, l);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - l + 1);

        }
        return maxLen;
    }

}
