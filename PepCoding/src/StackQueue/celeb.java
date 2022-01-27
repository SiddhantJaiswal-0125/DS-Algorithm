package StackQueue;

import java.io.*;
import java.util.*;

public class celeb {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebOptimal(arr);

    }

    //O(N)
    static void findCelebOptimal(int arr[][]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++)
            st.push(i);
        while (st.size()>1)
        {
            int i = st.pop();
            int j = st.pop();
            if(arr[i][j] == 1)
                st.push(j);
            else
                st.push(i);
        }
        int ind = st.pop();
       if( checkfinal(arr, n, ind))
           System.out.println(ind);
       else System.out.println("none");


    }




        //O(N^2)
    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        int n = arr.length;

        for(int i =0;i<n;i++)
        {
            if(celeb(arr[i],n, i))
            {

                if(checkfinal(arr, n, i))
                {
                    System.out.println(i);
                    return;
                }
            }
        }


        System.out.println("none");
        return;


    }
    static boolean checkfinal(int ar[][], int size, int ind)
    {
        for(int i = 0;i<size;i++)
        {
            if(i == ind)
                continue;
            if(ar[i][ind] == 0)
                return false;
        }
        return true;
    }

    static boolean celeb(int ar[], int size, int ind)
    {
        for(int i = 0;i<size;i++)
        {
            if(i==ind)
                continue;
            else if(ar[i] == 1)
                return false;
        }
        return true;
    }

}