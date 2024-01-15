package queues;

public class QueuesArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public QueuesArray(int size) {
        maxSize = size;
        front = 0;
        rear = 0;
        queueArray = new int[maxSize];
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        queueArray[rear] = value;
        rear = (rear + 1) % maxSize;
        System.out.println("Enqueued: " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int dequeuedValue = queueArray[front];
        front = (front + 1) % maxSize;
        System.out.println("Dequeued: " + dequeuedValue);
        return dequeuedValue;

    }

    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int size() {
        return (rear - front + maxSize) % maxSize; 
    }

    public void peek() {
        System.out.println("In front: " + queueArray[front]);
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueuesArray queue = new QueuesArray(5);

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        queue.peek();
        
        System.out.println("Is queue full? " + queue.isFull());
        
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.peek();
        
        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.display();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();

        queue.peek();

        queue.display();
    }
}