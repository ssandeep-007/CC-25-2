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
    int idx = 0;
    Node buildTree(int[] arr) {
        if (idx >= arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node root = new Node(arr[idx++]);
        root.left = buildTree(arr);
        root.right = buildTree(arr);
        return root;
    }
}

public class Main {
    static boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.data == root2.data)
                && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        int[] arr1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++)
            arr1[i] = Integer.parseInt(input1[i]);

        String[] input2 = sc.nextLine().split(" ");
        int[] arr2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++)
            arr2[i] = Integer.parseInt(input2[i]);

        BuildTree bt1 = new BuildTree();
        BuildTree bt2 = new BuildTree();

        Node root1 = bt1.buildTree(arr1);
        Node root2 = bt2.buildTree(arr2);
        if (isMirror(root1, root2)) {
            System.out.println("The two trees are mirrors of each other.");
        } else {
            System.out.println("The two trees are not mirrors of each other.");
        }
    }
}
