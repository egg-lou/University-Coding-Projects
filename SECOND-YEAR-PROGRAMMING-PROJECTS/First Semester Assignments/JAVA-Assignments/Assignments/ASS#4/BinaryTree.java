import java.util.Scanner;

public class BinaryTree {
    Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("\nBinary Tree Traversal Program");
        System.out.println("Instructions: ");
        System.out.println("\tTo input nodes follow this format: PARENT,L-CHILD,R-CHILD");
        System.out.println("\tTo stop inputting nodes enter STOP\n");

        do {
            System.out.print("Input: ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("STOP")) {
                String[] nodeInput = input.split(",");
                tree.addNode(tree.root,nodeInput);
            }
        } while (!input.equalsIgnoreCase("STOP"));

        System.out.println();

        tree.treeDetails(tree.root);

        tree.getRoot(tree.root);

        System.out.print("\nPreorder Traversal: ");
        tree.Preorder(tree.root);

        System.out.print("\nInorder Traversal: ");
        tree.Inorder(tree.root);

        System.out.print("\nPostorder Traversal: ");
        tree.Postorder(tree.root);

        System.out.println();

        scanner.close();
    }

    public void addNode(Node currentNode, String[] input) {
        if (input.length != 3) {
            return;
        }

        String parentValue = input[0].trim();
        String leftValue = input[1].trim();
        String rightValue = input[2].trim();

        if (currentNode == null) {
            root = new Node(parentValue);
            addNode(root, input);
        } else if (currentNode.data.equals(parentValue)) {
            if (!leftValue.equalsIgnoreCase("null")) {
                currentNode.left = new Node(leftValue);
            }

            if (!rightValue.equalsIgnoreCase("null")) {
                currentNode.right = new Node(rightValue);
            }
        } else {
            if (currentNode.left != null) {
                addNode(currentNode.left, input);
            }
            if (currentNode.right != null) {
                addNode(currentNode.right, input);
            }
        }
    }

    public void Inorder(Node root) {
        if (root != null) {
            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);
        }
    }

    public void Preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }
    }

    public void Postorder(Node root) {
        if (root != null) {
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void getRoot(Node root) {
        System.out.println("Root of the tree: " + root.data);
    }

    public void treeDetails(Node root) {
        System.out.println("Node\tL-Subtree\tR-Subtree");
        treeDetailsHelper(root);
        System.out.println();
    }

    private void treeDetailsHelper(Node root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                System.out.printf("%s\t", root.data);

                if (root.left == null) {
                    System.out.print("null\t\t");
                } else {
                    System.out.printf("%s\t\t", root.left.data);
                }

                if (root.right == null) {
                    System.out.println("null");
                } else {
                    System.out.printf("%s\n", root.right.data);
                }
            }

            if (root.left != null) {
                treeDetailsHelper(root.left);
            }
            if (root.right != null) {
                treeDetailsHelper(root.right);
            }
        }
    }
}

class Node {
    String data;
    Node left, right;

    public Node(String value) {
        data = value;
        left = right = null;
    }
}