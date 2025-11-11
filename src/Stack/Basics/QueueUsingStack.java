package Stack.Basics;

import java.util.NoSuchElementException;
import java.util.Stack;

class Queue4{
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Queue4(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int data){
        //Move from s1 to s2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }


        //Push data to s1
        stack1.push(data);

        //Move from s2 to s1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

    }

    public int pop(){
            //Simply pop
            if (stack1.isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return stack1.pop();
    }

    public int peek(){
        if (stack1.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return stack1.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }
}

//Approach 2. Push is going to take less complexity. Usefull if input is much higher than output.

class Queue5 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Queue5(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int data){
        stack1.push(data);
    }

    public int dequeue(){
        if(!stack2.isEmpty()){
            stack2.pop();
        }
        else if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        else{
            throw new NoSuchElementException("Queue is empty");
        }
        return -1;
    }

    public int peek(){
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        else if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
        else{
            throw new NoSuchElementException("Queue is empty");
        }

    }
}

public class QueueUsingStack {



}
