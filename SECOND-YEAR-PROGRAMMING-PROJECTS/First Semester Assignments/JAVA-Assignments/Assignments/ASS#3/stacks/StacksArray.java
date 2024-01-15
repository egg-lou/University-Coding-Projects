public class StacksArray {

    private int maxSize;
    private int[] stackArray;
    private int top;


    public StacksArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top =-1;
    }

    public void peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty!");
        }
        System.out.println("Peek: " + stackArray[top]);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int pop() {
        if (top >= 0) {
            int poppedValue = stackArray[top--];
            System.out.println("Popped: " + poppedValue);
            return poppedValue;
        } else {
            System.out.println("Stack Underflow");
            return -1;
        
        }
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed: " + value);
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public void display() {
        System.out.println("Stack: ");
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int i = top; i >= 0; --i) {
            System.out.print(stackArray[i] + " ");
        }    
        System.out.println();
    }

    public static void main(String[] args) {
        StacksArray stack = new StacksArray(5);

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.peek();

        System.out.println("Is stack full? " + stack.isFull());

        stack.display();

        stack.pop();
        stack.pop();

        stack.display();

        stack.peek();
    }
}