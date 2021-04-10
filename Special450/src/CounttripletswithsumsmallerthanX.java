import java.util.*;

public class CounttripletswithsumsmallerthanX 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        long ans = solve(a,n,x);
        System.out.println(ans);

        sc.close();    
    }

    static long solve(int arr[], int n , int sum)
    {
        Arrays.sort(arr);
        long ans =0l;
        int l , r;
        for(int i =0;i<n-2;i++)
        {
            int j = i + 1, k = n - 1; 
       
           
            while (j < k) 
            { 
               
                if (arr[i] + arr[j] + arr[k] >= sum) 
                    k--; 
       
           
                else
                { 
                 
                    ans += (k - j); 
                    j++; 
                } 

         }
         }





        return ans;

    
    
    }
}