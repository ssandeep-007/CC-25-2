import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BuildTree {
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
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}



public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] tokens = line.split(" ");

        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.valueOf(tokens[i]);
        }

        BuildTree bt = new BuildTree();
        Node root = bt.buildTree(arr);

        System.out.println(bt.maxDepth(root));
    }
}
