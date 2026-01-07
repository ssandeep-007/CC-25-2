import java.util.*;

class MinStack
{
    public Stack<Integer> stack;
    int cap;
    int minVal;
    public MinStack(int size)
    {
        this.stack= new Stack<>();
        this.minVal=Integer.MAX_VALUE;
        this.cap=size;
    }
    public void push(int val)
    {
        if(stack.size()==cap)
        {
            System.out.println("overflow");
            return;
        }
        if (stack.isEmpty())
        {
            stack.push(val);
            minVal=val;
            System.out.println("Pushed "+ val);
        }
        else if (val>=minVal)
        {
            stack.push(val);
            System.out.println("Pushed "+ val);
        }
        else
        {
            int Encode=(2*val)-minVal;
            stack.push(Encode);
            minVal=val;
            System.out.println("Pushed "+ val);
        }

    }
    public int pop()
    {
        if (stack.isEmpty())
        {
            return -1;
        }

        int top=stack.pop();
        
        if (top>=minVal)
        {
            return top;
        }
        else
        {
            int originalMin=minVal;
            int prevMin= 2*minVal-top;
            minVal=prevMin;
            return originalMin;
        }

    }
    public int peek()
    {
        if (stack.isEmpty())
        {
            return -1;
        }

        int top=stack.peek();
       
        if(top>=minVal)
        {
            return top;
        }
        else
        {
            return minVal;
        }
    }
    public int getMin()
    {
        if (stack.isEmpty())
        {
            return -1;
        }
        else
        {
            return minVal;
        }

    }

}

public class Main
{
    public static void main(String[] args)
    {
        
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        MinStack st=new MinStack(N);
        
        while(true)
        {
        int op= sc.nextInt();
        switch (op)
        {
            case 1:
                int val=sc.nextInt();
                st.push(val);
                break;
            case 2:
                int res=st.pop();
                if(res==-1)
                {
                    System.out.println("underflow");
                }
                break;
            case 3:
                int x=st.peek();
                System.out.println("Top: "+x);
                break;
            case 4:
                int y= st.getMin();
                System.out.println("Min: "+y);
                break;
            case 5:
                System.out.println("Exit");
                break;
        }
    }
    }
}
