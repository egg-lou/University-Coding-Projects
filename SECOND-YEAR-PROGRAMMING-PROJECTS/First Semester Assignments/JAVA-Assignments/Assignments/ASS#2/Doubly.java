public class Doubly {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

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

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private DoublyNode head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        DoublyNode newNode = new DoublyNode(data);

        if (head == null) {
            head = newNode;
        } else {
            DoublyNode current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        DoublyNode current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    public void traverse() {
        DoublyNode current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean search(int data) {
        DoublyNode current = head;

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
            DoublyNode current = head;
            DoublyNode previous = null;

            while (current != null && current.next != null) {
                if (current.data > current.next.data) {
                    DoublyNode temp = current.next;
                    current.next = current.next.next;
                    if (current.next != null) {
                        current.next.prev = current;
                    }

                    temp.next = current;
                    temp.prev = previous;

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