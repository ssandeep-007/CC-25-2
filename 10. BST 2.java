import java.util.*;

class Node 
{
    int data;
    Node left, right;
    Node(int data) 
    {
        this.data = data;
        left = right = null;
    }
}

class BST 
{
    int idx = 0;
    public Node buildTree(int[] arr) {
        if (idx >= arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node root = new Node(arr[idx++]);
        root.left = buildTree(arr);
        root.right = buildTree(arr);

        return root;
    }
    public boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return isBST(root.left, min, root.data) &&
               isBST(root.right, root.data, max);
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.valueOf(input[i]);
        }

        BST bst = new BST();
        Node root = bst.buildTree(arr);

        boolean result = bst.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(result);
    }
}
