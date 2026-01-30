import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BuildTree {
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

    public Node lca(Node root, int n1, int n2) {
        if (root == null) return null;

        if (n1 < root.data && n2 < root.data) {
            return lca(root.left, n1, n2);
        }

        if (n1 > root.data && n2 > root.data) {
            return lca(root.right, n1, n2);
        }

        return root; // split point
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        BuildTree bst = new BuildTree();

        for (String s : input) {
            int val = Integer.parseInt(s);
            if (val != -1) {
                bst.insert(val);
            }
        }
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        Node lcaNode = bst.lca(bst.root, n1, n2);

        System.out.println(
            "The Lowest Common Ancestor of " + n1 + " and " + n2 +
            " is " + lcaNode.data + "."
        );
    }
}
