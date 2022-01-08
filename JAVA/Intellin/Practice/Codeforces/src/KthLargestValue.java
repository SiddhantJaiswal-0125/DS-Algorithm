import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestValue
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int a[]  = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<n;i++)
        {
            a[i] = sc.nextInt();
            pq.add(a[i]);
        }
        while(q-->0)
        {
            int t = sc.nextInt();
            if(t==1)
            {
                int x = sc.nextInt();
                int p = a[x-1];
                pq.remove(a[x-1]);
                pq.add(1-p);
                a[x-1]  = 1-p;
            }
            else
            {
                int k = sc.nextInt();
                ArrayList<Integer> al = new ArrayList<>();
                int p =1;
                while(p<k)
                {
                    al.add(pq.poll());
                    p++;
                }
                System.out.println(pq.peek());
                int i =0;
                while(i<al.size()) {
                    pq.add(al.get(i));
                    i++;
                }

            }
        }



    }
}
