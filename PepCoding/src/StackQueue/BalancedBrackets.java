package StackQueue;
import java.io.*;
import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solve(str));
    }
    static boolean solve(String str)
    {
        int size = str.length();
        Stack<Character>  st = new Stack<>();
        for(int i =0;i<size; i++)
        {
            char c = str.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                st.push(c);
            else if(c==']')
            {
                if(st.isEmpty() || st.peek() !='[')
                    return false;
                st.pop();
            }
            else if(c=='}')
            {
                if(st.isEmpty() || st.peek() !='{')
                    return false;
                st.pop();
            }
            else if(c==')')
            {
                if(st.isEmpty() || st.peek() !='(')
                    return false;
                st.pop();
            }
        }


        return st.isEmpty();

    }


}