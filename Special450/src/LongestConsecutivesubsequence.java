import javax.security.sasl.SaslClient;
import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutivesubsequence
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        int ans = new LongestConsecutivesubsequence().solve(a,n);
        System.out.println(ans);
    }
    int solve(int a[] , int n)
    {
        int ans = 0;
        HashSet <Integer> bag = new HashSet<Integer>();
        for(int i : a)
            bag.add(i);
        for(int i = 0;i<n;i++)
        {
            if(!bag.contains(a[i]-1))
            {
                int j = a[i];
                while(bag.contains(j))
                    j++;

                if(ans<j-a[i])
                    ans = j-a[i];

            }
        }
        return ans ;
    }
}
