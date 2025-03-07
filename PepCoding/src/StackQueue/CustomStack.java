package StackQueue;

import java.io.*;
import java.util.*;

public class CustomStack {

    public static class CustomStack1{
        int[] data;
        int tos;


        public CustomStack1(int cap) {
            data = new int[cap];
            tos = -1;
            ArrayList<Integer> ar = new ArrayList<>();

        }

        int size() {
            // write ur code here
            return tos+1;

        }

        void display() {
            // write ur code here
            int ind = tos;
            while(ind>=0)
            {
                System.out.print(data[ind--]+" ");
            }

            System.out.println();

        }

        void push(int val) {
            // write ur code here
            if(tos == data.length-1)
            {
                System.out.println("Stack overflow");
                return;
            }
            tos++;
            data[tos] =  val;


        }

        int pop() {
            // write ur code here
            if(tos==-1)
            {
                System.out.println("Stack underflow");
                return -1;
            }


            return data[tos--];
        }

        int top() {
            // write ur code here
            if(tos==-1)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            return data[tos];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack1 st = new CustomStack1(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            } else if(str.startsWith("display")){
                st.display();
            }
            str = br.readLine();
        }
    }
}