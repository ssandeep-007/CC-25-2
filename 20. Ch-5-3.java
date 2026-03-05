import java.util.*;
class Node 
{
    int key;
    int value;
    Node next;
    Node(int key, int value) 
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable 
{
    int SIZE = 10;
    Node[] table;
    HashTable() 
    {
        table = new Node[SIZE];
    }

    int hashFunc(int key) 
    {
        return key % SIZE;
    }

    public void insert(int key, int value) 
    {
        int index = hashFunc(key);
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;

        System.out.println("Inserted: (" + key + "," + value + ")");
    }

    public void delete(int key) 
    {
        int index = hashFunc(key);
        Node curr = table[index];
        Node prev = null;
        while (curr != null) 
        {
            if (curr.key == key) 
            {
                if (prev == null) 
                {
                    table[index] = curr.next;
                } 
                else 
                {
                    prev.next = curr.next;
                }
                curr.next = null;
                System.out.println("Key " + key + " deleted successfully.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Key " + key + " not found.");
    }

    public void retrieve(int key) 
    {
        int index = hashFunc(key);
        Node curr = table[index];
        while (curr != null) 
        {
            if (curr.key == key) 
            {
                System.out.println(key + " -> " + curr.value);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Key " + key + " not found.");
    }

    public void display() 
    {
        for (int i = 0; i < SIZE; i++) 
        {
            if (table[i] != null) 
            {
                System.out.print("Index " + i + ": ");
                Node curr = table[i];
                while (curr != null) 
                {
                    System.out.print("(" + curr.key + "," + curr.value + ") ");
                    curr = curr.next;
                }
                System.out.println();
            }
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        HashTable ht = new HashTable();
        while (true) 
        {
            int op = sc.nextInt();
            if (op == 1) 
            {
                int key = sc.nextInt();
                int value = sc.nextInt();
                ht.insert(key, value);
            } 
            else if (op == 2) 
            {
                int key = sc.nextInt();
                ht.delete(key);
            } 
            else if (op == 3) 
            {
                int key = sc.nextInt();
                ht.retrieve(key);
            } 
            else if (op == 4) 
            {
                ht.display();
            } 
            else if (op == 5) 
            {
                System.out.println("Exit");
                break;
            }
        }
    }
}
