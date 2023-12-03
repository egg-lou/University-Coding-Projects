public class Single {
        public static void main (String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

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

class Node {
    int data;
    Node next;

    public Node (int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
        private Node head;

        public SinglyLinkedList () {
            this.head = null;
        }

        public void insert(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            }
            else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }

                current.next = newNode;
            }
        }

        public void delete(int data) {

            if (head == null) {
                return;
            }

            if (head.data == data) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }
        }

        public void traverse () {
            Node current = head;

            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public boolean search(int data) {
            Node current = head;

            while (current != null) {
                if (current.data == data) {
                    return true;
                }  
                current = current.next;
            }
            return false;
        }

        public void sort() {
        if (head == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node previous = null;

            while (current != null && current.next != null) {
                if (current.data > current.next.data) {
                    Node temp = current.next;
                    current.next = current.next.next;
                    temp.next = current;

                    if (previous != null) {
                        previous.next = temp;
                    } else {
                        head = temp;
                    }

                    swapped = true;
                }

                previous = current;
                current = current.next;
            }
        } while (swapped);
    }
}