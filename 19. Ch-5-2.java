import java.util.*;

class Node 
{
    int key, value;
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

    int hash(int key) 
    {
        return key % SIZE;
    }

    void insert(int key, int value) 
    {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) 
        {
            table[index] = newNode;
        } 
        else 
        {
            Node temp = table[index];
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted: (" + key + "," + value + ")");
    }

    void search(int key) {
        int index = hash(key);
        Node temp = table[index];

        while (temp != null) 
        {
            if (temp.key == key) 
            {
                System.out.println(key + " -> " + temp.value);
                return;
            }
            temp = temp.next;
        }
    }

    void display() {
        for (int i = 0; i < SIZE; i++) 
        {
            System.out.print(i + ": ");
            Node temp = table[i];
            if (temp == null) 
            {
                System.out.println("NULL");
            } 
            else 
            {
                while (temp != null) 
                {
                    System.out.print("(" + temp.key + "," + temp.value + ")-> ");
                    temp = temp.next;
                }
                System.out.println("NULL");
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
            int choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    int key = sc.nextInt();
                    int value = sc.nextInt();
                    ht.insert(key, value);
                    break;
                case 2:
                    int searchKey = sc.nextInt();
                    ht.search(searchKey);
                    break;
                case 3:
                    ht.display();
                    break;
                case 4:
                    System.out.println("Exit");
                    return;
            }
        }
    }
}
