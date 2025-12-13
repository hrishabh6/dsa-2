package SlidingWindow;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int left = 0, right = 0;
        int sIndex = -1, minLen = Integer.MAX_VALUE;
        int count = 0;

        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            hash[s.charAt(right)]--;

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    sIndex = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);

    }

}
