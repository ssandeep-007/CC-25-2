import java.util.*;
class Node{
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
    public static Node mergeLL(Node H1, Node H2)
    {
        if(H1==null) return H2;
        if(H2==null) return H1;
        Node t1=H1;
        Node t2=H2;
        Node fHead;
        if(t1.data<t2.data)
        {
            fHead=t1;
            t1=t1.next;
        }
        else
        {
            fHead=t2;
            t2=t2.next;
        }
        Node Temp=fHead;
        while(t1!=null && t2!=null)
        {
            if(t1.data<t2.data)
            {
                Temp.next=t1;
                t1=t1.next;
            }
        else
            {
                Temp.next=t2;
                t2=t2.next;
            }
            Temp=Temp.next;
        }
        if(t1!=null) Temp.next=t1;
        if(t2!=null) Temp.next=t2;
        return fHead;
    }
    public static Node createLL(String input)
    {
        Node head=null;
        Node tail= null;
        String[] arr=input.split(" ");
        for(String x: arr)
        {
            int val= Integer.valueOf(x);
            if(val==-1) break;
            Node newNode= new Node(val);
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                tail.next=newNode;
                tail=newNode;
            }
        }
        return head;
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String line1= sc.nextLine();
        String line2= sc.nextLine();
        Node H1= createLL(line1);
        Node H2= createLL(line2);
        Node Head= mergeLL(H1,H2);
        Node temp=Head;
        while(temp!=null)
        {
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
    }
}
