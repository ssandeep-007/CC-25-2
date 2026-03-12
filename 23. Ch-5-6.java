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
    TrieNode root= new TrieNode();
    int Count=0;

    void insert(String word) 
    {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) 
        {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) 
            {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }

        if (!current.flag) 
        {
            current.flag = true;
            Count++;
        }
    }

    int UniqueWordCount() 
    {
        return Count;
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            String word = sc.next();
            trie.insert(word);
        }

        System.out.println(trie.UniqueWordCount());
    }
}
