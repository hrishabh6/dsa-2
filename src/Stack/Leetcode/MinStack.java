package Stack.Leetcode;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            min = val;
        } else {
            if (val > min) {
                stack.push(val);
            } else {
                stack.push(val*2-min);
                min = val;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            throw new RuntimeException("Stack Underflow");
        }
        int val = stack.pop();
        if(val < min){
            min = 2*min-val;
        }
    }

    public int top() {
        if(stack.isEmpty()){
            throw new RuntimeException("Stack Underflow");
        }
        int x = stack.peek();
        if(x < min){
            return 2*min-x;
        } else {
            return x;
        }
    }

    public int getMin() {
        return min;
    }
}

