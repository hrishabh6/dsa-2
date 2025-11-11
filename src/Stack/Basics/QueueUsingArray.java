package Stack.Basics;

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public Queue(int size){
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    public void enqueue(int data){
        if(rear == size-1){
            throw new RuntimeException("Queue Overflow");
        } else{
            rear++;
            arr[rear] = data;
        }
    }

    public int dequeue(){
        if(front == rear){
            throw new RuntimeException("Queue Underflow");
        } else{
            int data = arr[front];
            front++;
            return data;
        }
    }

    public int peek(){
        if(front == rear){
            throw new RuntimeException("Queue Underflow");
        } else{
            return arr[front];
        }
    }

    public boolean isEmpty(){
        return front == rear;
    }
}

public class QueueUsingArray {
}
