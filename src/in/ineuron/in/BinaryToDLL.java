package in.ineuron.in;
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTreeToDLL {
    Node root;
    Node head; // Head of the doubly linked list

    // Helper function to perform the conversion
    private void convertToDLL(Node node) {
        if (node == null)
            return;

        // Recursively convert the left subtree
        convertToDLL(node.left);

        // Process the current node
        if (head == null) {
            // If head is null, it means we are processing the leftmost node
            head = node;
        } else {
            // Otherwise, set the current node's left pointer to the previous node
            node.left = head;
            // Set the previous node's right pointer to the current node
            head.right = node;
            // Move the head pointer to the current node
            head = node;
        }

        // Recursively convert the right subtree
        convertToDLL(node.right);
    }

    // Function to print the doubly linked list
    private void printDLL(Node head) {
        Node current = head;
        System.out.println("Doubly Linked List:");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();

        // Constructing the binary tree
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        // Convert the binary tree to DLL
        tree.convertToDLL(tree.root);

        // Print the DLL
        tree.printDLL(tree.head);
    }
}
