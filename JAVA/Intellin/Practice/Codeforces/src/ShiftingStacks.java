import java.util.*;
public class ShiftingStacks
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         while(t-->0)
         {
             int n = sc.nextInt();
             long h[] = new long[n];
             for(int i =0;i<n;i++)
                 h[i] = sc.nextInt();

             long c=0l;
             long left = 0l;
             boolean check = true;
             for(int i =0;i<n;i++)
             {
                 if(h[i]>=c)
                     left+=(h[i] - c);


                 else
                 {

                         //h[i]  is < c
                            if(h[i]+left >= c)
                             left -= (c-h[i]);
                         else
                         {

                             check = false;
                             break;
                         }



                     }





                 c++;
             }

             if(check)
                 System.out.println("YES");
             else
                 System.out.println("NO");




         }
    }
}
