public class StacksLinkedList {
    private Node top;

    public StacksLinkedList() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (top != null) {
            int poppedValue = top.data;
            top = top.next;
            System.out.println("Popped: " + poppedValue);
            return poppedValue;
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return top.data;
    }

    public void display() {
        System.out.println("Stack: ");

        if(isEmpty()) {
            System.out.println("empty");
        }

        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StacksLinkedList stack = new StacksLinkedList();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.display();

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.peek();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}