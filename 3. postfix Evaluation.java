import java.util.*;

public class PostfixEvaluation
{
    public static void postfixEvaluator(String exp)
    {
        Stack<Integer> st=new Stack<>();
        String[] arr= exp.split(" ");
        for(String x:arr)
        {
            try
            {
                int val=Integer.valueOf(x);
                st.push(val);
                continue;
            }
            catch(NumberFormatException e)
            {

            }
            char ch=x.charAt(0);
            if(st.size()<2)
            {
                System.out.println("Evaluation failed due to errors in the expression.");
                return;
            }
            else
            {
                int v1=st.pop();
                int v2=st.pop();
                int res=0;
                switch(ch)
                {
                    case '+': res=v1+v2; break;
                    case '*': res=v1*v2; break;
                    case '-': res=v2-v1; break;

                    case '/':
                    if(v1==0)
                    {
                        System.out.println("Error: Division by zero.");
                        System.out.println("Evaluation failed due to errors in the expression.");
                        return;
                    }
                    res= v2/v1;
                    break;

                    case '^':
                    res= (int) Math.pow(v2,v1);
                    break;
                }
                st.push(res);
            }
        }
        if(st.size()!=1)
        {
            System.out.println("Evaluation failed due to errors in the expression.");
            return;
        }
        System.out.println(st.pop());
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        postfixEvaluator(input);
    }
}
