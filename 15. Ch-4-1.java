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

    BuildTree() {
        this.root = null;
    }

    // Insert into BST
    void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insertRecursion(root, data);
        }
    }

    void insertRecursion(Node node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insertRecursion(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insertRecursion(node.right, data);
            }
        }
    }

    // Check leaf node
    boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    // Left boundary (excluding leaf)
    void leftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    // Right boundary (excluding leaf)
    void rightBoundary(Node root, List<Integer> res) {
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            curr = (curr.right != null) ? curr.right : curr.left;
        }

        // Add in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    // Leaf nodes
    void leafNodes(Node root, List<Integer> res) {
        if (root == null) return;

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        leafNodes(root.left, res);
        leafNodes(root.right, res);
    }

    // Boundary traversal
    List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.data);              // Root
        leftBoundary(root, res);         // Left boundary
        leafNodes(root.left, res);       // Left subtree leaves
        leafNodes(root.right, res);      // Right subtree leaves
        rightBoundary(root, res);        // Right boundary

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        BuildTree bt = new BuildTree();

        for (String s : input) {
            int val = Integer.parseInt(s);
            if (val != -1) {
                bt.insert(val);
            }
        }

        List<Integer> result = bt.boundaryTraversal(bt.root);
        System.out.print("Boundary Traversal: ");
        for (int v : result) {
            System.out.print(v + " ");
        }
    }
}
