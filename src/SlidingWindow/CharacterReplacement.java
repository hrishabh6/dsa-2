package SlidingWindow;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0, max = 0, maxFreq = 0;
        int[] hash = new int[26];

        for (int right = 0; right < s.length(); right++) {

            hash[s.charAt(right) - 'A']++;


            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

}
