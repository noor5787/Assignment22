package in.ineuron2;
//Node class to represent a node in the binary tree
class Node {
 int data;
 Node left, right;
 
 public Node(int item) {
     data = item;
     left = right = null;
 }
}

//Binary tree class with flip operation
class BinaryTree {
 Node root;
 
 public BinaryTree() {
     root = null;
 }
 
 // Method to perform the flip operation
 public void flipBinaryTree() {
     root = flip(root);
 }
 
 // Helper method to recursively flip the binary tree
 private Node flip(Node node) {
     if (node == null || (node.left == null && node.right == null)) {
         return node;
     }
     
     Node flippedNode = flip(node.left);
     
     node.left.left = node.right;
     node.left.right = node;
     node.left = node.right = null;
     
     return flippedNode;
 }
 
 // Method to print the flipped binary tree
 public void printBinaryTree() {
     printTree(root);
 }
 
 // Helper method to recursively print the binary tree
 private void printTree(Node node) {
     if (node == null) {
         return;
     }
     
     System.out.print(node.data + " ");
     printTree(node.left);
     printTree(node.right);
 }
}

//Main class to test the program
public class Main {
 public static void main(String[] args) {
     BinaryTree tree = new BinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     
     System.out.println("Original Binary Tree:");
     tree.printBinaryTree();
     
     tree.flipBinaryTree();
     
     System.out.println("\nFlipped Binary Tree:");
     tree.printBinaryTree();
 }
}
