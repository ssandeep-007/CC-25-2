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

public class Main
{
    static int idx = 0;
    public static Node buildTree(int[] arr) {
    if (idx >= arr.length || arr[idx] == -1) {
        idx++;
        return null;
    }

        Node root = new Node(arr[idx++]);
        root.left = buildTree(arr);
        root.right = buildTree(arr);
        return root;
    }

    public static boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    public static void leftBoundary(Node node, List<Integer> res) {
        Node curr = node;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void leafNodes(Node node, List<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        leafNodes(node.left, res);
        leafNodes(node.right, res);
    }

    public static void rightBoundary(Node node, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        Node curr = node;

        while (curr != null) {
            if (!isLeaf(curr)) {
                stack.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    public static void boundaryTraversal(Node root) {
        if (root == null) return;
        List<Integer> result = new ArrayList<>();
        result.add(root.data);
        leftBoundary(root.left, result);
        leafNodes(root.left, result);
        leafNodes(root.right, result);
        rightBoundary(root.right, result);

        System.out.print("Boundary Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String[] input= sc.nextLine().split(" ");
        int[] arr= new int[input.length];
        for(int i=0;i<input.length;i++)
        {
            arr[i]=Integer.valueOf(input[i]);
        }

        Node root = buildTree(arr);
        boundaryTraversal(root);
    }
}
