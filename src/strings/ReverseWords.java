package strings;

public class ReverseWords {
    //Leetcode 151 reverse words in a string
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();;
        String reversed = new StringBuilder(s).reverse().toString();

        for(int i = 0; i < reversed.length(); i++){
            StringBuilder word = new StringBuilder();;
            while(i < reversed.length() && reversed.charAt(i) != ' '){
                word.append(reversed.charAt(i));
                i++;
            }
            if(word.isEmpty()) continue;
            ans.append(word.reverse().toString()).append(" ");

        }
        return ans.deleteCharAt(ans.length()-1).toString();
    }

    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(str  + " Original String");
        String result = reverseWords(str);
        if(result.isEmpty()) System.out.println("Empty String");
        else System.out.println(result + " Reversed String");
    }

}
