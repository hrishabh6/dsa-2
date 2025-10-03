package strings;

public class RemoveOuterParenthesis {
    //Leetcode problem 1021. Remove Outermost Parentheses

    public String removeOuterParentheses(String s) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for(char str : s.toCharArray()){
            if(str == '('){
                if(counter != 0){
                    sb.append(str);
                }
                counter++;
            } else {
                counter--;
                if(counter != 0){
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
