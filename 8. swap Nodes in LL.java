import java.util.*;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Main 
{
    public static Node pairwiseSwap(Node head) 
    {
        if(head==null || head.next==null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        while (prev.next != null && prev.next.next != null) 
        {
            Node first = prev.next;
            Node second = first.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(" ");
        Node head = null, tail = null;
        for (String x : arr) {
            int val = Integer.valueOf(x);
            if (val == -1)
                break;
            Node newNode = new Node(val);
            if (head == null) 
            {
                head = tail = newNode;
            } 
            else 
            {
                tail.next = newNode;
                tail = newNode;
            }
        }
        Node Fhead = pairwiseSwap(head);
        Node temp = Fhead;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
