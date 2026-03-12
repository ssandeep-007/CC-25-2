import java.util.*;

class TrieNode 
{
    Map<Character, TrieNode> children;
    boolean flag;
    public TrieNode() 
    {
        children = new HashMap<>();
        flag = false;
    }
}

class Trie 
{
    TrieNode root;
    Trie() 
    {
        root = new TrieNode();
    }
    void insert(String word) 
    {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) 
        {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.flag = true;
        System.out.println("Inserted: " + word);
    }

    boolean search(String word) 
    {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) 
        {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) 
            {
                return false;
            }
            current = node;
        }
        return current.flag;
    }

    void remove(String word) 
    {
        if (!search(word)) 
        {
            System.out.println("Not found: " + word);
            return;
        }
        removeRecursion(root, word, 0);
        System.out.println("Removed: " + word);
    }

    public boolean removeRecursion(TrieNode current, String word, int index) 
    {
        if (index == word.length()) 
        {
            current.flag = false;
            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        boolean shouldDeleteChild = removeRecursion(node, word, index + 1);

        if (shouldDeleteChild) 
        {
            current.children.remove(ch);
            return !current.flag && current.children.size() == 0;
        }
        return false;
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        while (true) 
        { 
            int op = Integer.valueOf(sc.nextLine().trim());
            if (op == 1) 
            {
                trie.insert(sc.nextLine());
            } 
            else if (op == 2) 
            {
                String word = sc.nextLine();
                if (trie.search(word)) 
                {
                    System.out.println("Found: " + word);
                } 
                else 
                {
                    System.out.println("Not found: " + word);
                }
            } 
            else if (op == 3) 
            {
                trie.remove(sc.nextLine());
            } 
            else if (op == 4) 
            {
                break;
            }
        }
    }
}
