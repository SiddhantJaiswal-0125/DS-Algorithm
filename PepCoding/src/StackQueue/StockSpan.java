package StackQueue;

import java.io.*;
import java.util.*;

public class StockSpan {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val +" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr){


        int size = arr.length;
        int ngl[] = new int[size];
        Stack<pair> st = new Stack<pair>();
        for(int i =0;i<size;i++)
        {

            while(st.isEmpty()==false && st.peek().ele<=arr[i])
                st.pop();


            if(st.isEmpty()==true)
                ngl[i] = i+1;
            else
                ngl[i] = i - st.peek().ind ;

            st.push(new pair(arr[i], i));


        }



        return ngl;
    }
    static class pair{
        int ind;
        int ele;

        pair(int a, int b)
        {
            ele = a;
            ind = b;
        }

    }

}