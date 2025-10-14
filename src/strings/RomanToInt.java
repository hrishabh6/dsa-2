package strings;

public class RomanToInt {
    public int getVal(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length()-1 && getVal(s.charAt(i)) < getVal(s.charAt(i+1))){
                ans -= getVal(s.charAt(i));
            }else{
                ans += getVal(s.charAt(i));
            }
        }
        return ans;
    }
}
