package StackQueue;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class InfixConversion
{
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        String post = solvepost(exp);
        System.out.println(post);
        String pre = solvepre(exp);
        System.out.println(pre);



    }

    static String solvepost(String exp)
    {
        int size =  exp.length();
        Stack<Character> optors = new Stack<>();
        Stack<String> oprnds = new Stack<>();

        for(int i  =0;i<size;i++) {
            char ch = exp.charAt(i);
            if (ch == '(')
                optors.push(ch);
            else if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                oprnds.push("" + ch);
            } else if (ch == ')') {
                while (optors.size() > 0 && optors.peek() != '(') {
                    char optor = optors.pop();
                    String val2 = oprnds.pop();
                    String val1 = oprnds.pop();
                    String res = operationtopostfix(val1, val2, optor);
                    oprnds.push(res);
                }
                optors.pop();
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while(optors.size()>0 && optors.peek()!='(' && precedence(ch) <= precedence(optors.peek()))
                {
                    char optor = optors.pop();
                    String val2 = oprnds.pop();
                    String val1 = oprnds.pop();
                    String res = operationtopostfix(val1, val2, optor);
                    oprnds.push(res);
                }
                optors.push(ch);


            }



        }

        while(optors.size()>0 )
        {
            char optor = optors.pop();
            String val2 = oprnds.pop();
            String val1 = oprnds.pop();
            String res = operationtopostfix(val1, val2, optor);
            oprnds.push(res);
        }
        return new String(oprnds.pop());
    }
    static String solvepre(String exp)
    {
        int size =  exp.length();
        Stack<Character> optors = new Stack<>();
        Stack<String> oprnds = new Stack<>();

        for(int i  =0;i<size;i++) {
            char ch = exp.charAt(i);
            if (ch == '(')
                optors.push(ch);
            else if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                oprnds.push("" + ch);
            } else if (ch == ')') {
                while (optors.size() > 0 && optors.peek() != '(') {
                    char optor = optors.pop();
                    String val2 = oprnds.pop();
                    String val1 = oprnds.pop();
                    String res = operationtopostprefix(val1, val2, optor);
                    oprnds.push(res);
                }
                optors.pop();
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while(optors.size()>0 && optors.peek()!='(' && precedence(ch) <= precedence(optors.peek()))
                {
                    char optor = optors.pop();
                    String val2 = oprnds.pop();
                    String val1 = oprnds.pop();
                    String res = operationtopostprefix(val1, val2, optor);
                    oprnds.push(res);
                }
                optors.push(ch);


            }



        }

        while(optors.size()>0 )
        {
            char optor = optors.pop();
            String val2 = oprnds.pop();
            String val1 = oprnds.pop();
            String res = operationtopostprefix(val1, val2, optor);
            oprnds.push(res);
        }
        return new String(oprnds.pop());
    }
    static int precedence(char ch)
    {
        if(ch == '+' || ch == '-')
            return  1;
        return  2;

    }
    static String operationtopostfix(String a, String b, char ch)
    {
        return  new String(a+b+""+ch);
    }
    static String operationtopostprefix(String a, String b, char ch)
    {
        return  new String(ch+""+a+b);
    }
}
