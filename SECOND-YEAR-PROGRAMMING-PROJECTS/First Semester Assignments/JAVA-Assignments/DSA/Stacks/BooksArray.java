public class BooksArray {
    private static final int FIXED_SIZE = 3;
    private String[] books;
    private int size;


    public BooksArray() {
        books = new String[FIXED_SIZE];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String author, String title) {
        if (size < FIXED_SIZE) {
            String signedBook ="Signed by " + author + " - " + title;
            books[size++] = signedBook;
            System.out.println("Book added: " + signedBook);
        } else {
            System.out.println("Stack is full. Cannot sign more books.");
        }
    }

    public String pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty. No books to unsign.");
            return null;
        }

        String unsignedBook = books[--size];
        books[size] = null;
        System.out.println("Book unsigned: " + unsignedBook);
        return unsignedBook;
    }

    public String peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty. No books to peek.");
            return null;
        }

        return books[size - 1];
    }

     public void printBooks() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("Books on the stack:");
            System.out.println("{");
            for (int i = size - 1; i >= 0; i--) {
                System.out.println("  "  + "\"" + books[i] + "\"");
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        BooksArray books = new BooksArray();

        books.push("J.K. Rowling", "Harry Potter and the Philosopher's Stone");
        books.push("J.K. Rowling", "Harry Potter and the Chamber of Secrets");
        books.push("J.K. Rowling", "Harry Potter and the Prisoner of Azkaban");

        books.printBooks();

        System.out.println("Peek at the top book: " + books.peek());

        books.push("Rick Riordan", "Percy Jackson and the Olympians: The Lightning Thief");

        books.printBooks();

        System.out.println("Unsigning books...");

        books.pop();

        books.printBooks();

        books.pop();
        books.pop();
        books.pop();

        books.printBooks();
    }
}