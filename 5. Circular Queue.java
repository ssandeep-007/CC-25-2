import java.util.*;

class CircularQueue
{
    int[] arr;
    int rear;
    int front;
    int count;
    int cap;
    public CircularQueue(int k)
    {
        this.cap=k;
        arr=new int[cap];
        this.count=0;
        this.rear=-1;
        this.front=0;
    }
    public void enqueue(int x)
    {
        if(count==cap)
        {
            System.out.println("Queue Overflow");
            return;
        }
        rear= (rear+1)%cap;
        arr[rear]=x;
        count++;
        System.out.println("Enqueued "+x);
    }
    public void dequeue()
    {
        if(count==0)
        {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Dequeued "+arr[front]);
        front= (front+1)%cap;
        count--;

    }
}
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int k= sc.nextInt();
        CircularQueue cq= new CircularQueue(k);
        while(sc.hasNextInt())
        {
            int val=sc.nextInt();
            if(val==-1) cq.dequeue();
            else cq.enqueue(val);
        }
    }
}
