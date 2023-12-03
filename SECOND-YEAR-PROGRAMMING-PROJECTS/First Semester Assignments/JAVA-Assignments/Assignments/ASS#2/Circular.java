public class Circular {
    public static void main(String[] args) {
        CircularDoublyLinkedList linkedList = new CircularDoublyLinkedList();

        linkedList.insert(18);
        linkedList.insert(20);
        linkedList.insert(2);
        linkedList.insert(5);
        linkedList.insert(1);

        System.out.println();
        System.out.print("Original Linked List: ");
        linkedList.traverse();
        System.out.println();

        System.out.println("Is 20 present in the list? " + linkedList.search(20));
        System.out.println();

        linkedList.delete(2);
        System.out.print("Linked list after deleting 2: ");
        linkedList.traverse();
        System.out.println();

        linkedList.sort();
        System.out.print("Sorted Linked List: ");
        linkedList.traverse();
        System.out.println();
    }
}

class CircularDoublyNode {
    int data;
    CircularDoublyNode next;
    CircularDoublyNode prev;

    public CircularDoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularDoublyLinkedList {
    private CircularDoublyNode head;

    public CircularDoublyLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        CircularDoublyNode newNode = new CircularDoublyNode(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            CircularDoublyNode last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        CircularDoublyNode current = head;

        do {
            if (current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;

                if (current == head) {
                    head = current.next;
                }

                return;
            }

            current = current.next;
        } while (current != head);
    }

    public void traverse() {
        if (head == null) {
            return;
        }

        CircularDoublyNode current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }

    public boolean search(int data) {
        if (head == null) {
            return false;
        }

        CircularDoublyNode current = head;

        do {
            if (current.data == data) {
                return true;
            }

            current = current.next;
        } while (current != head);

        return false;
    }

    public void sort() {
        if (head == null || head.next == head) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            CircularDoublyNode current = head;

            do {
                if (current.data > current.next.data) {
                    CircularDoublyNode temp = current.next;
                    current.next = temp.next;
                    temp.next.prev = current;

                    temp.next = current;
                    temp.prev = current.prev;
                    current.prev.next = temp;
                    current.prev = temp;

                    swapped = true;
                }

                current = current.next;
            } while (current != head);
        } while (swapped);
    }
}