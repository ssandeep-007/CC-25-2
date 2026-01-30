import java.util.*;

class Node {
    String data;
    Node left;
    Node right;

    Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BST {
    Node root;
    public void insert(String data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insertRecursion(root, data);
        }
    }
    public void insertRecursion(Node node, String data) {
        if (data.compareTo(node.data) < 0) 
        {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insertRecursion(node.left, data);
            }
        } 
        else 
        {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insertRecursion(node.right, data);
            }
        }
    }
    public List<String> leftView() 
    {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = q.poll();

                if (i == 0) {
                    result.add(node.data);
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        BST bst = new BST();

        for (int i = 0; i < n; i++) 
        {
            String keyword = sc.nextLine();
            bst.insert(keyword);
        }

        List<String> leftViewResult = bst.leftView();
        System.out.println(String.join(" ", leftViewResult));
    }
}
