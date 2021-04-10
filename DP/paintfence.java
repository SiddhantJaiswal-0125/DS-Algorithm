import java.util.*;


public class paintfence 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        // int k = sc.nextInt();
        int ans = sol(n);
        System.out.println(ans);
        sc.close();
    }
    static int sol(int n)
    {
            int m = 1000000007;
            int k =2;
            //let k = 2;
            int total = k;
            // int ans = k;
            if(n==1)
            return k;

            else
            {
                // int row = 1;÷
                int dif =   mul(k, k-1, m);
                int same = k;
    
                total = add(same, dif, m);

              

            for(int i=3;i<=n;i++)
            {
                
                same = dif%m;
                dif = mul(total, k-1, m);
                total = add(same,dif,m);
                
               
             }

        }
        return total;

    }
    static int add(int a , int b, int m)
    {
        return ((a%m) +(b%m) )%m;
    }
    static int mul(int a , int b, int m)
    {
        return ((a%m) * (b%m) )%m;
    }
    
    
}

