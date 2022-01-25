package StackQueue;

import java.io.*;
import java.util.*;

public class infix{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        int res = solve(exp);
        System.out.println(res);
    }

    static int solve(String exp)
    {
        int size = exp.length();
        Stack<Character> optors = new Stack<>();
        Stack<Integer> oprnds = new Stack<>();
        for(int i  =0;i<size;i++)
        {
            char ch = exp.charAt(i);
            if(ch == '(')
                optors.push(ch);
            else if(Character.isDigit(ch))
                oprnds.push(ch-'0');
            else if(ch == ')')
            {
                while (optors.size() > 0 && optors.peek() != '(')
                {
                    int v2 = oprnds.pop();
                    int v1 = oprnds.pop();
                    char optor = optors.pop();
                    int res = operation(v1, v2, optor);
                    oprnds.push(res);
                }
                optors.pop();
            }
            else if(ch == '+' || ch == '-' || ch== '*' || ch == '/')
            {
                while(optors.size() >0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek() ) )
                {
                    int v2 = oprnds.pop();
                    int v1 = oprnds.pop();
                    char optor = optors.pop();
                    int res = operation(v1, v2, optor);
                    oprnds.push(res);

                }

                optors.push(ch);

            }





        }

        while (optors.size() > 0) {
            int val2 = oprnds.pop();
            int val1 = oprnds.pop();
            char op = optors.pop();

            int opval = operation(val1, val2, op);
            oprnds.push(opval);
        }


        return oprnds.pop();
    }


    static int operation(int v1, int v2, char optor)
    {
        if(optor == '+')
            return v1+v2;
        else  if(optor == '-')
            return v1-v2;
        else  if(optor == '*')
            return v1*v2;
        else
            return v1/v2;
    }

    static int precedence(char optor)
    {
        if(optor == '+' || optor == '-')
            return 1;
        return 2;
    }
}