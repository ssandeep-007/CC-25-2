import java.util.*;
class Node
{
    int data;
    Node next;
    public Node(int x)
    {
        this.data=x;
        this.next=null;
    }
}

public class Main
{
    public static int findMerge(Node H1,Node H2)
    {
        Node t1=H1;
        Node t2=H2;
        while(t1!=null && t2!=null)
        {
            if(t1.data==t2.data)
            {
                return t1.data;
            }
            else if(t1.data<t2.data)
            {
                t1=t1.next;
            }
            else
            {
                t2=t2.next;
            }
        }
        return -1;
    }
    public static Node createLL(String input)
    {
        String[] arr= input.split(" ");
        Node head=null;
        Node tail=null;
        for(String x: arr)
        {
            int val=Integer.valueOf(x);
            if(val==-1) break;

            Node newnode= new Node(val);
            if(head==null)
            {
                head=newnode;
                tail=newnode;
            }
            else
            {
                tail.next=newnode;
                tail=newnode;
            }
        }
        return head;
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String line1=sc.nextLine();
        String line2=sc.nextLine();

        Node H1=createLL(line1);
        Node H2=createLL(line2);

        System.out.println(findMerge(H1,H2));
    }
}

