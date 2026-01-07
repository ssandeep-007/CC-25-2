import java.util.*;

public class NextGreaterElement 
{
    public static int[] nextGreaterElement(int[] arr) 
    {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) 
        {
            int current = arr[i];

            while (!stack.isEmpty() && stack.peek() <= current) 
            {
                stack.pop();
            }

            if (!stack.isEmpty()) 
            {
                nge[i] = stack.peek();
            } 
            else 
            {
                nge[i] = -1;
            }
            stack.push(current);
        }

        return nge;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        int[] result = nextGreaterElement(arr);
        for(int i=0;i<n;i++)
        {
            System.out.println("NGE of "+arr[i]+" is "+result[i]);
        }
    }
}
