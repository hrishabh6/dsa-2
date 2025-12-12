package SlidingWindow;

public class SubstringWithAll3Chars {

    public int numberOfSubstrings(String s) {
        int[] hashArr = {-1,-1,-1};
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            hashArr[s.charAt(i) - 'a']++;
            if(hashArr[0] != -1 && hashArr[1] != -1 && hashArr[2] != -1) count += 1 + Math.min(hashArr[0], Math.min(hashArr[1], hashArr[2]));
        }
        return count;

    }

}
