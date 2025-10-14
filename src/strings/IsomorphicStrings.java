package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if(!map.containsKey(schar)){
                if(!map.containsValue(tchar)){
                    map.put(schar, tchar);
                }
                else return false;
            }
            else{
                if(map.get(schar) != tchar) return false;
            }
        }
        return true;
    }
}
