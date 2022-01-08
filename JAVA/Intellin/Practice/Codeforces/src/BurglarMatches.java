import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class BurglarMatches
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int m = sc.nextInt();
        Pair p[] = new Pair[m];
        for(int i =0;i<m;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            p[i] = new Pair(a,b);

        }
        Arrays.sort(p);
        Queue <Integer> q = new ArrayDeque<>();
        


        int size = m-1;
        long total = 0l;
        while(n>0 && size>=0)
        {
            if(n>p[size].totalMatchbox)
            {
                total+= (p[size].totalMatchbox * p[size].matches);
                n -=p[size].totalMatchbox;

            }
            else {

                total+= (n * p[size].matches);
                n =0;
            }



            size--;
        }

        System.out.println(total);







    }
   static class Pair  implements Comparable<Pair>{
        int totalMatchbox;
        int matches;
        Pair(int a, int b)
        {
           totalMatchbox = a;
           matches = b;

        }


       @Override
       public int compareTo(Pair o) {
           return this.matches - o.matches;
       }
   }
}
