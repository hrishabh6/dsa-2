package Stack.Basics;

    class QueueNode{
        int data;
        QueueNode next;

        public QueueNode(int data){
            this.data = data;
            next = null;
        }
    }

    class Queue2{
        int size;
        QueueNode front;
        QueueNode rear;

        public Queue2(){
            size = 0;
            front = null;
            rear = null;
        }

        public void enqueue(int data){
            QueueNode temp = new QueueNode(data);
            if(front == null){
                front = rear = temp;
            } else {
                rear.next = temp;
                rear = temp;
            }
            size++;
        }

        public int dequeue(){
            if(front == null){
                throw new RuntimeException("Queue Underflow");
            }
            QueueNode temp = front;
            front = front.next;
            size--;
            return temp.data;
        }

    }

public class QueueUsingLL {



}
