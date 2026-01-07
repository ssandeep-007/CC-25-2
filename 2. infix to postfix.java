import java.util.*;

public class InfixToPostfixQueue 
{
    public static int precedence(char op) 
    {
        switch (op) 
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static boolean isRightAssociative(char op) {
        return (op == '^');
    }

    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^');
    }

    public static String infixToPostfix(String exp) 
    {
        Queue<Character> output = new LinkedList<>();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) 
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) 
            {
                output.offer(c);
            }
            else if (c == '(') 
            {
                st.push(c);
            }
            else if (c == ')') 
            {
                while (!st.isEmpty() && st.peek() != '(') 
                {
                    output.offer(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') 
                {
                    st.pop();
                } 
            }
            else if (isOperator(c)) 
            {
                while (!st.isEmpty() && isOperator(st.peek())) 
                {
                    char top = st.peek();
                    if ((precedence(top) > precedence(c)) ||
                       (precedence(top) == precedence(c) && !isRightAssociative(c))) {
                        output.offer(st.pop());
                    } 
                    else 
                    {
                        break;
                    }
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) 
        {
            //if (ops.peek() == '(') {
              //  return "Invalid Expression"; 
            //}
            output.offer(st.pop());
        }

        String result = "";
        while (!output.isEmpty()) {
            result = result + output.poll()+" ";
        }

        return result;
    }

    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        String exp=sc.nextLine();
        System.out.println(infixToPostfix(exp));
        
    }
}
