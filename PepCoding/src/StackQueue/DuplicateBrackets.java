package StackQueue;

import java.io.*;
import java.util.*;

public class DuplicateBrackets
{
    public static void main(String args[]) throws  Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solve(str));

    }
    static boolean solve(String str)
    {
        int size = str.length();
        Stack<Character>  st = new Stack<>();
        for (int i =0;i<size;i++)
        {
            char c = str.charAt(i);
            if(c!=')')
                st.push(c);
            else
            {
                if(st.peek()=='(')
                    return true;
                else
                    while(st.peek() !='(')
                        st.pop();
                    st.pop();
            }
        }
        return false;
    }
}
