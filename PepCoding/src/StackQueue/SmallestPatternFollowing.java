package StackQueue;

import java.util.*;
import java.io.*;

public class SmallestPatternFollowing
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        solve(exp);
    }
    static void solve(String exp)
    {
        Stack<Integer>  st = new Stack<>();
        int size = exp.length();

        int count =1;
        String result = "";

        for(int i =0;i<size;i++)
        {
            char ch = exp.charAt(i);
            st.push(count++);
            if(ch == 'i')
            {
                while(st.isEmpty()==false)
                {
                    result += ""+st.pop();
                }
            }
        }
       
        st.push(count);
        while(st.isEmpty()==false)
        {
            result += ""+st.pop();
        }


        System.out.println(result);
    }
}
