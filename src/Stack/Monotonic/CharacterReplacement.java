package Stack.Monotonic;

public class CharacterReplacement {

        public int characterReplacement(String s, int k) {
            int left = 0, max = 0, maxFreq = 0;
            int[] hash = new int[26];

            for (int right = 0; right < s.length(); right++) {
                // ✅ correctly update frequency
                hash[s.charAt(right) - 'A']++;

                // ✅ update max character frequency in window
                maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

                // ✅ shrink window if replacements exceed k
                while ((right - left + 1) - maxFreq > k) {
                    hash[s.charAt(left) - 'A']--;
                    left++;
                }

                // ✅ update result
                max = Math.max(max, right - left + 1);
            }

            return max;
        }


}
