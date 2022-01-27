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

        findCelebrity(arr);

    }

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