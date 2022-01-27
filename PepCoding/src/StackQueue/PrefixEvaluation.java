package StackQueue;
import java.util.*;
import java.io.*;

public class PrefixEvaluation
{
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new
                BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        int val = prefixCompute(exp);
        System.out.println(val);
        String infix = prefixToInfix(exp);
        System.out.println(infix);
        String postfix = prefixToPostfix(exp);
        System.out.println(postfix);
    }
    static String prefixToInfix(String exp)
    {
        Stack<String> infix = new Stack<>();
        for(int i =  exp.length()-1; i>=0;i--)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
            {
                infix.push(""+ch);

            }
            else
            {
                String a = infix.pop();
                String b = infix.pop();
                String res = "("+a + ""+ch+""+b+")";
                infix.push(res);
            }
        }
        return  infix.pop();
    }
    static String prefixToPostfix(String exp)
    {
        Stack<String> postfix = new Stack<>();
        for(int i =  exp.length()-1; i>=0;i--)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
            {
                postfix.push(""+ch);

            }
            else
            {
                String a = postfix.pop();
                String b = postfix.pop();
                String res = a+""+b+""+ch;
                postfix.push(res);
            }
        }
        return  postfix.pop();
    }

    static int prefixCompute(String exp)
    {
        Stack <Integer> val = new Stack<>();
        int size = exp.length();
        for(int i = size -1;i>=0;i--)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
                val.push(ch-'0');
            else
            {
                int a = val.pop();
                int b = val.pop();
                int res = compute(a,b,ch);
                val.push(res);
            }
        }


        return  val.pop();
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
