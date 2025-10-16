package strings;

public class Beauty {

    public int beautySum(String s) {
        int ans = 0;
        for(int size = 3; size <= s.length(); size++){
            int i = 0;
            int j = size;
            int[] frequency = new int[26];
            for(int k = i; k < j; k++){
                frequency[s.charAt(k) - 'a']++;
            }
            ans += beauty(frequency);
            while(j < s.length()){
                frequency[s.charAt(i) - 'a']--;
                frequency[s.charAt(j) - 'a']++;
                ans += beauty(frequency);
                i++;
                j++;
            }

        }
        return ans;
    }

    private int beauty(int[] frequency){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : frequency){
            if(i != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        return max - min;
    }

}
