import java.util.Scanner;
import java.util.Random;

class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
        }

class BinarySearchTree{
    private Node root;

    public BinarySearchTree(){
        root = null;}

    public void insert(int data){
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;}

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (data < current.data){
                current = current.left;} else if (data > current.data){
                current = current.right;
            } else {
                return;}
            }
        if (data < parent.data) {
            parent.left = newNode;} else {
            parent.right = newNode;} }

    public void delete(int data) 
        {
        root = deleteRec(root, data);}

    private Node deleteRec(Node root, int data) 
        {
        if (root == null){
            return null;}
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data){
            root.right = deleteRec(root.right, data);} else {
            // the node that can be deleted is now found
            // use this in the case of a parent node only having 1 or 0 children
            if (root.left == null){
                return root.right; } else if (root.right == null) {
                return root.left;}
            // used in the circumstance if the parent node has 2 children
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);}
        return root;
         }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null){
            minv = root.left.data;
            root = root.left;}
        return minv;}

    public void inorder(){
        inorderRec(root);
        System.out.println();}

    private void inorderRec(Node root){
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);}
            }

    public void preorder(){
        preorderRec(root);
        System.out.println();}

    private void preorderRec(Node root){
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);}
            }

    public void postorder(){
        postorderRec(root);
        System.out.println();}

    private void postorderRec(Node root){
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");}
            }
    }

public class binarytree{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        Random random = new Random();

        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Generate the pre-determined nodes for the tree");
            System.out.println("2. Add a node");
            System.out.println("3. Delete a node");
            System.out.println("4. Print nodes by InOrder");
            System.out.println("5. Print nodes by PreOrder");
            System.out.println("6. Print nodes by PostOrder");
            System.out.println("7. Exit program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
	               switch (choice) {
                case 1:
                for (int i = 0; i < 32; i++) {int node = random.nextInt(4096);
                        bst.insert(node);}
                    System.out.println("32 nodes generated");
                    break;

                case 2:
                    System.out.print("Enter value to insert: ");
                    int valueToAdd = scanner.nextInt();
                    bst.insert(valueToAdd);
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    int valueToDelete = scanner.nextInt();
                    bst.delete(valueToDelete);
                    break;
                case 4:
                    System.out.print("Nodes by InOrder traversal: ");
                    bst.inorder();
                    break;
                case 5:
                    System.out.print("Nodes by PreOrder traversal: ");
                    bst.preorder();
                    break;
                case 6:
                    System.out.print("Nodes by PostOrder traversal: ");
                    bst.postorder();
                    break;
                case 7:
                    System.out.println("Exiting");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, enter a valid option");
                             }       
                    }
         }
}
