package PriorityQueue;

import java.io.*;
import java.util.*;

public class SortKSortedArray {



        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int ind = 0;
            for(int i :arr)
            {
                pq.add(i);
                if(pq.size()>k)
                    arr[ind++] = pq.remove();


            }

            while(pq.isEmpty() == false)
                arr[ind++] = pq.remove();

            for(int  i : arr)
                System.out.println(i);


        }


}
