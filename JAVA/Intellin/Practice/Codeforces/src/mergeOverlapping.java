
import java.util.*;

public class mergeOverlapping
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pair li[] =new pair[n];
        for(int i =0;i<n;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            li[i] = new pair(x, y);
        }

        Arrays.sort(li);

        for(pair p : li)
            System.out.println(p.x+"\t"+p.y);


        int ind = 1;
        int start = li[0].x;
        int end = li[0].y;

        ArrayList<pair> arl = new ArrayList<>();
        while(ind<n)
        {
           if(li[ind].x>end)
           {
               arl.add(new pair(start, end));
               start = li[ind].x;
               end = li[ind].y;
               ind++;
           }
           else
           {
               end = li[ind].y;
               ind++;
           }

        }

        arl.add(new pair(start, end));


        System.out.println("MERGED");
        for(pair pi:arl)
            System.out.println(pi.x+"\t"+pi.y);



    }

    static class pair implements Comparable<pair>
    {
        int x, y;
        pair(int a, int b)
        {
            x = a;
            y =b;
        }


        @Override
        public int compareTo(pair o) {
            return this.x - o.x;
        }
    }
}
