import java.util.Scanner;
import  java.util.Stack;
public class ParenthisisChecker
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            String s = sc.next();
            System.out.println(isValid(s));
        }
    }
    static boolean isValid(String s)
    {
        int n = s.length();
        Stack <Character> st = new Stack<>();
        for(int i = 0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                st.push(c);
            else if(c=='}')
            {
                if(!st.isEmpty()&& st.peek()=='{')
                    st.pop();
                else
                    return false;


            }
            else if (c==']')
            {
                if(!st.isEmpty()&& st.peek()=='[')
                    st.pop();
                else
                    return false;


            }
            else if(c==')')
            {
                if(!st.isEmpty()&& st.peek()=='(')
                    st.pop();
                else
                    return false;
            }

        }
        return  st.isEmpty();

    }
}
