package Stack.Monotonic;

import java.util.Stack;

public class RemoveK {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek() > c){
                stack.pop();
                k--;
            }
            if(c != '0' || !stack.isEmpty()){
                stack.push(c);
            }
        }
        while(!stack.isEmpty() && k > 0 ){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";

        //Build the result
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
