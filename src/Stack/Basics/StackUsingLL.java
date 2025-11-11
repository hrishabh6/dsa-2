package Stack.Basics;

class StackNode{
    int data;
    StackNode next;

    public StackNode(int data){
        this.data = data;
        next = null;
    }
}

class Stack2{
    StackNode top;
    int size;

    public Stack2(){
        top = null;
        size = 0;
    }

    public void push(int data){
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop(){
        if(top == null){
            throw new RuntimeException("Stack Underflow");
        }
        top = top.next;
        size--;
        return top.data;
    }

    public int peek(){
        return top.data;
    }

    public int size(){
        return size;
    }
}

public class StackUsingLL {


}
