import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    int idx = 0;
    public Node buildTree(List<Integer> arr) 
    {
        if (idx >= arr.size() || arr.get(idx) == -1) 
        {
            idx++;
            return null;
        }

        Node root = new Node(arr.get(idx++));
        root.left = buildTree(arr);
        root.right = buildTree(arr);

        return root;
    }


    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
}

public class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) 
        {
            list.add(sc.nextInt());
        }
        BinaryTree t=new BinaryTree();
        Node root = t.buildTree(list);
        t.levelOrder(root);
    }
}
