package Stack.Basics;

import java.util.NoSuchElementException;
import java.util.Queue;

class Stack3 {
    Queue<Integer> queue;

    public Stack3(){
        queue = new java.util.LinkedList<>();
    }

    public void push(int data){
        int size = queue.size();
        queue.add(data);

        for(int i = 0; i < size; i++){
            queue.add(queue.poll());
        }
    }


    public int pop() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return queue.poll();
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return queue.peek();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }

}

public class StackUsingQueue {
}
