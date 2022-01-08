import java.util.HashSet;
import java.util.Scanner;
public class KindAnton
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int test = sc.nextInt() ;
         while(test-->0)
         {
             int n = sc.nextInt();
             int a[] = new int[n];
             int b[] =  new int[n];
             for(int i =0;i<n;i++)
                 a[i] = sc.nextInt();
             for(int  i = 0;i<n;i++)
                 b[i] = sc.nextInt();
             if(isPossible(a,b,n))
                 System.out.println("YES");
             else
                 System.out.println("NO");


         }
    }
    static  boolean isPossible(int a[], int b[], int n)
    {
        boolean contains1 =false;
        boolean containsneg = false;


        if(a[0]!=b[0])
            return  false;
        if(a[0]==1)
            contains1 =true;
        else if(a[0] == -1)
            containsneg = true;


        for(int i = 0;i<n;i++)
        {

            if(a[i] > b[i] )
            {
                if(!containsneg)
                    return false;
            }
          else  if(a[i] < b[i])
            {
                if(!contains1)
                    return false;
            }

               if(a[i]==1)
                   contains1 =true;
             if(a[i] == -1)
                   containsneg = true;


//                if (a[i] > b[i] && !good[0]) {
//                    cout << "NO\n";
//                    return;
//                } else if (a[i] < b[i] && !good[1]) {
//                    cout << "NO\n";
//                    retx

        }


        return  true;
    }


}
