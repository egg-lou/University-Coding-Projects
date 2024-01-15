public class MoviesLL {

    private class Node {
        String title;
        String director;
        boolean isWatched;
        Node next;

        Node (String title, String director, boolean isWatched) {
            this.title = title;
            this.director = director;
            this.isWatched = isWatched;
            this.next = null;
        }
    }

    private Node top;
    private int size;
    private static final int FIXED_SIZE = 3;

    public MoviesLL() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String title, String director, boolean isWatched) {
        if (size < FIXED_SIZE) {
            Node newNode = new Node(title, director, isWatched);
            newNode.next = top;
            top = newNode;
            size++;
            System.out.println("Movie added: " + title);
        } else {
            System.out.println("Stack is full. Cannot add more movies.");
        }
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty. No movies to remove.");
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
            size--;
            System.out.println("Movie removed: " + temp.title);
        }
    }

    public String peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty. No movies to peek.");
            return null;
        }

        Node topMovie = top;

        return "Top movie: " + topMovie.title + " by " + topMovie.director + (topMovie.isWatched ? " (watched)" : " (not watched)");
    }

    public void printMovies() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("Movies on the stack:");
            System.out.println("{");
            Node temp = top;
            while (temp != null) {
                System.out.println("  \"" + temp.title + "\" directed by " + temp.director + (temp.isWatched ? " (Watched)" : " (Not Watched)"));
                temp = temp.next;
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        MoviesLL movies = new MoviesLL();

        movies.push("The Shawshank Redemption", "Frank Darabont", true);
        movies.push("The Godfather", "Francis Ford Coppola", true);
        movies.push("The Dark Knight", "Christopher Nolan", false);
        movies.push("The Godfather: Part II", "Francis Ford Coppola", false);

        movies.printMovies();

        System.out.println("Movie at the top: " + movies.peek());

        movies.pop();
        movies.pop();

        System.out.println("Movie at the top: " + movies.peek());

        movies.pop();
        movies.pop();

        movies.push("Titanic", "James Cameron", false);
        movies.printMovies();

    }
}