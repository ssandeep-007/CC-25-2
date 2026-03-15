import java.util.*;

class Node 
{
    char ch;
    int freq;
    Node left;
    Node right;
    Node(char ch, int freq) 
    {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}

class HuffmanCoding 
{

    String[] chars;
    int[] freq;
    Node root;
    Map<Character, String> codes;

    HuffmanCoding(String[] chars, int[] freq) {
        this.chars = chars;
        this.freq = freq;
        this.codes = new HashMap<>();
    }
    void buildTree() 
    {
        PriorityQueue<Node> heap =new PriorityQueue<>((a, b) -> 
        {
            if (a.freq == b.freq)
                return a.ch - b.ch;
            return a.freq - b.freq; 
        }
        );

        for (int i = 0; i < chars.length; i++) 
        {
            heap.add(new Node(chars[i].charAt(0), freq[i]));
        }

        while (heap.size() > 1) 
        {
            Node left = heap.poll();
            Node right = heap.poll();
            Node merged = new Node('$', left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            heap.add(merged);
        }
        root = heap.peek();
    }

    void generateCodes(Node node, String code) 
    {
        if (node == null)
            return;
        if (node.left == null && node.right == null) 
        {
            codes.put(node.ch, code);
            return;
        }
        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    void display() 
    {
        System.out.println("Huffman Codes:");
        for (String ch : chars) 
        {
            char c = ch.charAt(0);
            System.out.println(c + ": " + codes.get(c));
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] chars = sc.nextLine().split(" ");
        String[] freqInput = sc.nextLine().split(" ");
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) 
        {
            freq[i] = Integer.valueOf(freqInput[i]);
        }

        HuffmanCoding huffman = new HuffmanCoding(chars, freq);
        huffman.buildTree();
        huffman.generateCodes(huffman.root, "");
        huffman.display();
    }
}
