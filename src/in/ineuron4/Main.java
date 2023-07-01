package in.ineuron4;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class TreeTraversalCheck {
    Node root;

    // Helper function to search an element in an array
    int search(int arr[], int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    // Recursive function to construct a binary tree from given
    // inorder and preorder traversals
    //
    Node buildTree(int inorder[], int preorder[], int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        // Take the next item from the preorder traversal
        // This would be the root node of the subtree
        Node node = new Node(preorder[buildTree.preIndex]);
        buildTree.preIndex++;

        // If the node has no children, return it
        if (inStart == inEnd)
            return node;

        // Find the index of this node in the inorder traversal
        int inIndex = search(inorder, inStart, inEnd, node.data);

        // Construct the left and right subtrees recursively
        node.left = buildTree(inorder, preorder, inStart, inIndex - 1);
        node.right = buildTree(inorder, preorder, inIndex + 1, inEnd);

        return node;
    }
    // Function to check if the given traversals belong to the same tree
    boolean isSameTree(int inorder[], int preorder[], int postorder[]) {
        // Build the tree using inorder and preorder traversals
        int len = inorder.length;
        root = buildTree(inorder, preorder, 0, len - 1);

        // Build the tree using inorder and postorder traversals
        int[] reversedPostorder = new int[len];
        for (int i = 0; i < len; i++) {
            reversedPostorder[i] = postorder[len - 1 - i];
        }
        buildTree.preIndex = 0;
        Node reversedRoot = buildTree(inorder, reversedPostorder, 0, len - 1);

        // Compare the two trees
        return isSame(root, reversedRoot);
    }

    // Helper function to compare two trees
    boolean isSame(Node node1, Node node2) {
        // Base cases
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;

        // Compare the current nodes and their subtrees recursively
        return (node1.data == node2.data) && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}

public class Main {
	
    public static void main(String[] args) {
        TreeTraversalCheck tree = new TreeTraversalCheck();

        int inorder[] = { 4, 2, 5, 1, 3 };
        int preorder[] = { 1, 2, 4, 5, 3 };
        int postorder[] = { 4, 5, 2, 3, 1 };

        if (tree.isSameTree(inorder, preorder, postorder))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
