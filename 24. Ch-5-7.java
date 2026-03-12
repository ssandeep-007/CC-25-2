import java.util.*;

class TrieNode 
{
    Map<Character,TrieNode> children;
    TrieNode() 
    {
        children= new HashMap<>();
    }
}

class DistinctSubstrings 
{
    TrieNode root;
    DistinctSubstrings() 
    {
        root = new TrieNode();
    }

    public int countDistinct(String s) 
    {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) 
        {
            TrieNode node = root;
            for (int j = i; j < n; j++) 
            {
                char ch = s.charAt(j);
                if (!node.children.containsKey(ch)) 
                {
                    node.children.put(ch, new TrieNode());
                    count++;
                }
                node = node.children.get(ch);
            }
        }
        return count;
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        DistinctSubstrings ob = new DistinctSubstrings();
        System.out.println(ob.countDistinct(s));
    }
}
