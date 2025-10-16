package strings;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        //Iterate over string and compare each character with the opposite character
        //If they are the same, continue
        //If they are not the same, return false
        //If we reach the end of the string, return true

        //Filter the string by replacing all spaces with empty string and special characters
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
