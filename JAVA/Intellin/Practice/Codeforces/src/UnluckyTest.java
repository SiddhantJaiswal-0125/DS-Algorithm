import java.util.*;
public class UnluckyTest
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> res = allprimestillN(n);



        System.out.println(res);
    }
   static  ArrayList<Integer> allprimestillN(int n)
   {
       boolean prime[] = new boolean[n+1];
       for(int i=0;i<=n;i++)
           prime[i] = true;
       for(int ind = 2; ind*ind <=n; ind++)
           if(prime[ind] == true)
               for(int i = ind*ind; i <= n; i += ind)
                   prime[i] = false;


       ArrayList<Integer> res  = new ArrayList<>();
       for(int i = 2; i <= n; i++)
           if(prime[i] == true)
              res.add(i);

       return  res;
   }



}
