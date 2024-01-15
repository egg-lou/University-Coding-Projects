public class Main { // Driver class
    public static void main(String[] args) {
        LinkedList list = new LinkedList();  //Initialize a linked list

        list.insertAtBeginning(10); //Insert 10 at the beginning
        list.insertAtBeginning(20); //Insert 20 at the beginning

        list.insertAtEnd(30); //Insert 30 at the end
        list.insertAtEnd(40); //Insert 40 at the end

        list.insertAtPosition(50, 3); //Insert 50 at position 3
        list.insertAtPosition(60, 2); //Insert 60 at position 2

        System.out.println("Linked List: "); //Print the linked list
        list.display(); //Print the linked list

        list.deleteAtBeginning(); //Delete at beginning
        System.out.println("\nLinked List after deleting at beginning: "); //Print the linked list
        list.display(); //Print the linked list

        list.deleteAtEnd(); //Delete at end
        System.out.println("\nLinked List after deleting at end: "); //Print the linked list
        list.display(); //Print the linked list

        list.deleteAtPosition(3); //Delete at position 3
        System.out.println("\nLinked List after deleting at position 3: "); //Print the linked list
        list.display(); //Print the linked list

        list.reverse(); //Reverse the linked list
        System.out.println("\nLinked List after reversing: "); //Print the linked list
        list.display(); //Print the linked list
    }
}

class Node { // Node class
    int data; // Data
    Node next; // Next pointer

    public Node(int data) {
        this.data = data; // Initialize data
        this.next = null; // Initialize next pointer
    }
}

class LinkedList { // Linked list class
    Node head; // Head pointer

    public LinkedList() { // Constructor
        this.head = null; // Initialize head pointer
    }

    public void insertAtBeginning(int data) { // Insert at beginning
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) { // Insert at end
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtPosition(int data, int position) { // Insert at position
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteAtBeginning() { // Delete at beginning
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
        }
    }

    public void deleteAtEnd() { // Delete at end
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void deleteAtPosition(int position) { // Delete at position
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void display() { // Display the linked list
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    public void reverse() {  // Reverse the linked list
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        head = prev;
    }
}