package StackQueue;

import java.util.*;
import java.io.*;
public class PostfixEvaluation {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String postexp = br.readLine();
        int val = valueofExp(postexp);
        System.out.println(val);
        String infix = postfixToinfix(postexp);
        System.out.println(infix);

        String prefix = postfixtoprefix(postexp);
        System.out.println(prefix);


    }
    static String postfixtoprefix(String exp)
    {
        int size = exp.length();
        Stack<String> postfixToprefix = new Stack<>();

        for(int i =0;i<size;i++)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
                postfixToprefix.push(""+ch);
            else
            {
                String b = postfixToprefix.pop();
                String a = postfixToprefix.pop();
                String res = ch+""+a+""+b;
                postfixToprefix.push(new String(res));
            }

        }
        return  postfixToprefix.pop();

    }
    static int valueofExp(String exp)
    {
        Stack<Integer>  val = new Stack<>();
        for(int i  =0;i<exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
            {
                val.push(ch-'0');
            }
            else
            {
                int b = val.pop();
                int a = val.pop();
                int res = compute(a,b,ch);
                val.push(res);
            }

        }

     return    val.pop();
    }
    static String postfixToinfix(String exp)
    {
        int size = exp.length();
        Stack<String> infix = new Stack<>();
        for(int i =0;i<size;i++)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
            {
                infix.push(""+ch);
            }
            else {
                String b = infix.pop();
                String a = infix.pop();
                String res = "("+a+""+ch+""+b+")";
                infix.push(new String(res));
            }
        }
        return  infix.pop();

    }

    static int compute(int a, int b, char ch)
    {
        if(ch == '+')
            return  a+b;
        if(ch == '-')
            return  a - b;
        if(ch == '*')
            return  a*b;

            return  a/b;

    }

}
