package PriorityQueue;
//https://leetcode.com/problems/ugly-number-ii/
import java.util.*;
public class Ugly2
{
    public int nthUglyNumber(int n) {
        if(n==1)
            return  1;

        ArrayList<Integer> ar = new ArrayList<>();
        int p = 0, q =0, r =0;
        ar.add(1);
        for(int i =1;i<n;i++)
        {
            int k5 = ar.get(p);
            int k2 = ar.get(q);
            int k3 = ar.get(r);
            int num = Math.min(k2*2, Math.min(k3*3,k5*5));
            if(num == k5*5)
                p++;
             if(num == k2*2)
                q++;
             if(num==k3*3)
                r++;
            ar.add(num);
        }

        return  ar.get(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = new Ugly2().nthUglyNumber(n);
        System.out.println(ans);
    }
}
