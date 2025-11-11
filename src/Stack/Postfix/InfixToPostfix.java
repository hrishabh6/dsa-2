package Stack.Postfix;

import java.util.Stack;

public class InfixToPostfix {

    public int priority(char c){
        if(c == '+' || c == '-') return 1;
        else if(c == '*' || c == '/') return 2;
        else if(c == '^') return 3;
        return 0;
    }

    public String infixToPostfix(String infix){
        int i = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (i < infix.length()){
            if((infix.charAt(i) >= 'A' && infix.charAt(i) < 'Z') ||
                    (infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z') ||
                    (infix.charAt(i) >= '0' && infix.charAt(i) <= '9' )
            ){
                sb.append(infix.charAt(i));
            } else if(infix.charAt(i) == '('){
                stack.push(infix.charAt(i));
            } else if(infix.charAt(i) == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                if(!stack.isEmpty()) stack.pop();
            } else {
                while(!stack.isEmpty() && priority(infix.charAt(i)) <= priority(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(infix.charAt(i));
            }
            i++;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public String infixToPrefix(String infix){
        //Reverse infix
        StringBuilder reversed = new StringBuilder();
        for(int i = infix.length()-1; i >= 0; i--){
            //Also convert the opening bracket to closing bracket and vice versa
            if(infix.charAt(i) == '(') reversed.append(')');
            else if(infix.charAt(i) == ')') reversed.append('(');
            else reversed.append(infix.charAt(i));
        }
        int i = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        while (i < reversed.length()){
            char ch = reversed.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            {
                ans.append(ch);
            } else if(ch == '('){
                stack.push(ch);
            } else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans.append(stack.pop());
                }
                if(!stack.isEmpty()) stack.pop();
            } else {
                if(ch == '^'){
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(ch)){
                        ans.append(stack.pop());
                    }
                } else {
                    while(!stack.isEmpty() && priority(stack.peek()) > priority(ch)){
                        ans.append(stack.pop());
                    }
                }
                stack.push(ch);
            }
            i++;
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        //return the reversed answer
        return ans.reverse().toString();
    }

    public String postfixToInfix(String postfix){
        int i = 0;
        Stack<String> stack = new Stack<>();

        while (i < postfix.length()){
            char ch = postfix.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                stack.push(String.valueOf(ch));

            } else {
                String top1 = stack.isEmpty() ? "" : stack.pop();
                String top2 = stack.isEmpty() ? "" : stack.pop();

                String temp = "(" + top2 + ch + top1 + ")";
                stack.push(temp);
            }
            i++;
        }
        return stack.pop();
    }

    public String prefixToInfix(String prefix){
        int i = prefix.length() -1;
        Stack<String> stack = new Stack<>();

        while (i >= 0){
            char ch = prefix.charAt(i);
            //If the char is a number or letter
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                stack.push(String.valueOf(ch));
            }
            else{
                String top1 = stack.isEmpty() ? "" : stack.pop();
                String top2 = stack.isEmpty() ? "" : stack.pop();
                String temp = "(" + top1 + ch + top2 + ")";
                stack.push(temp);
            }
            i--;
        }

        return stack.pop();
    }

    public String postfixToPrefix(String postfix){
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < postfix.length()){
            char ch = postfix.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                stack.push(String.valueOf(ch));
            } else {
                String top1 = stack.isEmpty() ? "" : stack.pop();
                String top2 = stack.isEmpty() ? "" : stack.pop();
                String temp = ch + top2 + top1;
                stack.push(temp);
            }
            i++;
        }
        return stack.pop();
    }

    public String prefixToPostfix(String prefix){
        int i = prefix.length() - 1;
        Stack<String> stack = new Stack<>();
        while (i >= 0 ){
            Character ch = prefix.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                stack.push(String.valueOf(ch));
            } else {
                String top1 = stack.isEmpty() ? "" : stack.pop();
                String top2 = stack.isEmpty() ? "" : stack.pop();
                String temp = top1 + top2 + ch;
                stack.push(temp);
            }
            i--;

        }
        return stack.pop();
    }


}
