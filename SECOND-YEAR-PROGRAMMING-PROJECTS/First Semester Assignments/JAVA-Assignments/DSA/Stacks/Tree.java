public class Tree {
    public static void main(String [] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(new Node(5));
        tree.insert(new Node(3));
        tree.insert(new Node(7));
        tree.insert(new Node(2));
        tree.insert(new Node(4));

        tree.display();
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void display() {
        System.out.print("In-order traversal: ");
        inOrder(root);

        System.out.print("\nPre-order traversal: ");
        preOrder(root);

        System.out.print("\nPost-order traversal: ");
        postOrder(root);
        System.out.println();
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if (node.data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void remove(int data) {
        if (search(data)) {
            root = removeHelper(root, data);
        } else {
            System.out.println(data + " is not in the tree.");
        }
    }

    private Node removeHelper(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = removeHelper(node.left, data);
        } else if (data > node.data) {
            node.right = removeHelper(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.right != null) {
                node.data = successor(node.right);
                node.right = removeHelper(node.right, node.data);
            } else {
                node.data = predecessor(node.left);
                node.left = removeHelper(node.left, node.data);
            }
        }

        return node;
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        } else if (data < root.data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }

    private int successor(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    private int predecessor(Node node) {
        Node current = node;

        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
}