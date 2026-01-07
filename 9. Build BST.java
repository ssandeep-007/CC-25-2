import java.util.*;
class Node 
{
    int data;
    Node left, right;
    Node(int data) 
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST 
{
    Node root;
    public void insert(int data) 
    {
        if (root == null)  root = new Node(data);
        else  insertRecursion(root, data);
    }

    public void insertRecursion(Node node, int data) 
    {
        if (data < node.data) 
        {
            if (node.left == null) 
            {
                node.left = new Node(data);
            } 
            else 
            {
                insertRecursion(node.left, data);
            }
        } 
        else 
        {
            if (node.right == null) 
            {
                node.right = new Node(data);
            } 
            else 
            {
                insertRecursion(node.right, data);
            }
        }
    }

    public void inOrder(Node node) 
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
}

public class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();         
        String[] tokens = line.split(" ");   
        BST tree = new BST();

        for (String token : tokens) 
        {
            int val = Integer.valueOf(token);
            if (val == -1)
                break;

            tree.insert(val);
        }

        tree.inOrder(tree.root);
    }
}
