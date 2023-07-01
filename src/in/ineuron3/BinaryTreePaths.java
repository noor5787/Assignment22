package in.ineuron3;
import java.util.Stack;

//Node class representing a node in the binary tree
class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = right = null;
 }
}

//Main class to print root-to-leaf paths without recursion
public class BinaryTreePaths {
 // Method to print all root-to-leaf paths without recursion
 public static void printPaths(Node root) {
     if (root == null)
         return;

     Stack<Node> nodeStack = new Stack<>();
     Stack<String> pathStack = new Stack<>();

     nodeStack.push(root);
     pathStack.push(Integer.toString(root.data));

     while (!nodeStack.isEmpty()) {
         Node current = nodeStack.pop();
         String path = pathStack.pop();

         // Check if the current node is a leaf node
         if (current.left == null && current.right == null) {
             System.out.println(path);
         }

         // Push the child nodes along with the updated path
         if (current.right != null) {
             nodeStack.push(current.right);
             pathStack.push(path + "->" + current.right.data);
         }
         if (current.left != null) {
             nodeStack.push(current.left);
             pathStack.push(path + "->" + current.left.data);
         }
     }
 }

 // Main method to test the program
 public static void main(String[] args) {
     Node root = new Node(6);
     root.left = new Node(3);
     root.right = new Node(5);
     root.left.left = new Node(2);
     root.left.right = new Node(5);
     root.right.right = new Node(4);
     root.left.right.left = new Node(7);
     root.left.right.right = new Node(4);

     System.out.println("Root-to-leaf paths:");
     printPaths(root);
 }
}
