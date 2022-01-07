package StackQueue;

import java.io.*;
import java.util.*;

 class Main{
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
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

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr){
        // solve
        int size = arr.length;
        int ngr[] = new int[size];
        Stack<Integer> st = new Stack<>();
        for(int i = size-1;i>=0;i--)
        {
            while(st.isEmpty()==false && st.peek()<=arr[i])
                st.pop();

            if(st.isEmpty()  ==true)
                ngr[i] = -1;
            else
                ngr[i] = st.peek();

            st.push(arr[i]);

        }

        return ngr;
    }

}