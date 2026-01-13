import java.util.*;

class Node 
{
    int data;
    Node left;
    Node right;
    Node(int data) 
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


class BuildTree 
{
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
    public void preorder(Node root) 
    {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) 
    {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void postorder(Node root) 
    {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (sc.hasNextInt()) 
        {
            arr.add(sc.nextInt());
        }
        BuildTree bt = new BuildTree();
        Node root = bt.buildTree(arr);

        bt.preorder(root);
        System.out.println();

        bt.inorder(root);
        System.out.println();

        bt.postorder(root);
    }
}
