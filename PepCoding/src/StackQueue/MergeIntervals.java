package StackQueue;

import java.util.*;
import  java.io.*;
public class MergeIntervals {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
       Pair []p = new Pair[arr.length];
       for(int i =0;i<arr.length;i++)
       {
           int s = arr[i][0];
           int e = arr[i][1];
           p[i] = new Pair(s,e);
       }
       Arrays.sort(p);


        Stack<Pair>  st  = new Stack<>();
        st.push(p[0]);
        for(int i =1 ;i<p.length;i++)
        {

            int start = p[i].start;
            int end = p[i].end;

            if(start > st.peek().end) {

                st.push(p[i]);
            }else
            {

                if(end < st.peek().end)
                    end = st.peek().end;
                if(start > st.peek().start)
                    start = st.peek().start;

                st.pop();
                st.push(new Pair(start, end));
            }
        }

        reverseStackPrint(st);
        return;

    }


    static void reverseStackPrint(Stack <Pair> st)
    {
        if(st.isEmpty())
            return;

        Pair p = st.pop();
        reverseStackPrint(st);

        System.out.println(p.start+" "+p.end);

    }
    static class Pair implements Comparable<Pair>
    {
        int start, end;

        Pair(int s, int e)
        {
            start = s;
            end = e;
        }
        public int compareTo(Pair oth)
        {
            if(this.end < oth.end)
                return  -1;
            if(this.end == oth.end && this.start < oth.start)
                return  -1;
            else return 1;

        }

    }
}
