package PriorityQueue;
import java.io.*;
import java.util.*;


public class KLargestElements {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        solve2(arr,k);





    }
    static void solve1(int arr[], int k )
    {
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr)
            pq.add(i);
        int i = 0;
        int ans []= new int[k];
        while(i<k)
        {
            ans[i] = pq.remove();
            i++;
        }

        for(int in = k-1;in>=0;in--)
            System.out.println(ans[in]);
    }
    static void solve2(int arr[], int k )
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i :arr)
        {
            pq.add(i);
            if(pq.size()>k)
                pq.remove();
        }

        while(pq.isEmpty() == false)
            System.out.println(pq.remove());

    }

}