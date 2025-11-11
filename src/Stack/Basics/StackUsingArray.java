package Stack.Basics;

class Stack {
    int[] arr;
    int top;
    int size;

    public Stack(int size){
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int data){
        if(top == size-1){
            throw new RuntimeException("Stack Overflow");
        }else{
            top++;
            arr[top] = data;
        }
    }

    public int pop(){
        if(top == -1){
            throw new RuntimeException("Stack Underflow");
        }else{
            int data = arr[top];
            top--;
            return data;
        }
    }

    public int peek(){
        if(top == -1){
            throw new RuntimeException("Stack Underflow");
        }else{
            return arr[top];
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }
}


public class StackUsingArray {



}
