import java.util.*;

class XOREQUAL 
{
    static long mod = 1000000007;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
                int n = sc.nextInt();
              

                long pow  = 1l;

                
                    long ans = power(n-1);
                
               
                
                System.out.println(ans);
        }
    }
   
    
    static long power( long y)
  {
    long res = 1l;
    long x = 2;
    x = x % mod; 
 
    if (x == 0)
      return 0; 
 
    while (y > 0)
    {
 
      
      if ((y & 1) != 0)
        res = (res * x) % mod;
 
     
      y = y >> 1; 
      x = (x * x) % mod;
    }
    return res;
  }
}
