package queues;

public class QueuesLinkedList{
    private Node front;
    private Node rear;

    public QueuesLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued: " + data);
    }


    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int dequeuedValue = front.data;
        front = front.next;
        System.out.println("Dequeued: " + dequeuedValue);
        return dequeuedValue;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("In front: " + front.data);
        }
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueuesLinkedList queue = new QueuesLinkedList();

        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.display();

        queue.peek();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();

        queue.peek();

        queue.enqueue(12);
        queue.enqueue(120);

        queue.display();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}