package strings;

public class AnagramStrings {
    public boolean isAnagram(String s, String t) {
        String str1 = s.toLowerCase();
        String str2 = t.toLowerCase();
        if(str1.length() != str2.length()) return false;

        str1 = str1.replaceAll(" ", "");
        str2 = str2.replaceAll(" ", "");

        int[] hashArray = new int[26];
        //Increment hashArray for str1
        for(int i = 0; i < str1.length(); i++){
            hashArray[str1.charAt(i) - 'a']++;
        }

        //Decrement hashArray for str2
        for(int i = 0; i < str2.length(); i++){
            hashArray[str2.charAt(i) - 'a']--;
        }

        //Check if hashArray is empty
        for(int i = 0; i < hashArray.length; i++){
            if(hashArray[i] != 0) return false;
        }
        return true;
    }
}
