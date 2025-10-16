package strings;

public class PalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String ans = "";

        for (int i = 1; i < s.length(); i++) {
            //Odd length
            int low = i ;
            int high = i ;

            while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }
            String palindrome = s.substring(low+1, high);
            if(ans.length() < palindrome.length()){
                ans = palindrome;
            }

            //Even length
            low = i - 1;
            high = i;

            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == s.length()){
                    break;
                }
            }

            palindrome = s.substring(low+1, high);
            if(ans.length() < palindrome.length()){
                ans = palindrome;
            }


        }
        return ans;

    }
}
