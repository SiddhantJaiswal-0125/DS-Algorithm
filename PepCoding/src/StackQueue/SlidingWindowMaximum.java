package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine());
        int ar[] =  new int[n];
        for(int i =0;i<n;i++)
            ar[i] = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());


        int ans[] = solve(ar, n, k);
        for(int i : ans)
            System.out.println(i);


    }
    static int[] solve(int ar[], int n, int k)
    {
        int ans [] =  new int[(n-k)+1];
        Stack<Integer> st = new Stack<Integer>();
        int ngr[] = new int[n];
        ngr[n-1] = n;
        st.push(n-1);
        for(int i = n-2;i>=0;i--)
        {
            while (st.size()>0 && ar[i] >= ar[st.peek()])
                st.pop();
            if(st.isEmpty())
                ngr[i] = n;
            else
                ngr[i] = st.peek();
            st.push(i);
        }




        int j = 0;
        for(int i =0;i<= (n-k);i++)
        {
           if(j<i)
           {
               j =i;
           }
           while(ngr[j]< i+k) {

               j = ngr[j];
           }
           ans [i] = ar[j];
        }


        return  ans;
    }
    static  void solve2(int arr[] , int k)
    {
        // nge begin
        int[] nge = new int[arr.length];
        Stack< Integer> st = new Stack<>();
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }
        System.out.println("INSIDE SOLVE 2");
        for(int i: nge)
            System.out.print(i+"\t");
        System.out.println();

        // nge end
        int i = 0;
        for (int w = 0; w <= arr.length - k; w++) {
            if (i < w) {
                i = w;
            }

            while (nge[i] < w + k) {
                i = nge[i];
            }
            System.out.println(arr[i]);

    }
    }
}
