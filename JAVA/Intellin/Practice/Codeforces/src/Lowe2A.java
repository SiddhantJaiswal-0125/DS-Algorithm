import java.util.*;

public class Lowe2A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("N:");
            int n = sc.nextInt();
            System.out.println("M:");
            int m = sc.nextInt();
            int mat[][] = new int[m][2];
            for (int i = 0; i < m; i++) {
                mat[i][0] = sc.nextInt();
                mat[i][1] = sc.nextInt();

            }



            int ans = solve(n, m, mat);
            System.out.println(ans);

        }
    }
    static  int solve(int n ,int m, int mat[][])
    {



         Interval[] list = new Interval[m];
        for(int i=0;i<m;i++)
        {
          Interval it =   new Interval(mat[i][0], mat[i][1]);
          list[i] = it;

        }

//        Arrays.sort(list, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                    if(o1.end== o2.end)
//                    {
//                        return  o2.start - o1.start;
//                    }
//                return o1.end - o2.end;
//            }
//        });
//
//        for(Interval i :list)
//            System.out.println(i.start+"\t"+i.end);
//
//
//
//        if(list[m-1].end<n)
//            return  -1;
//
//        int res  =n - list[m-1].start +1;
//        for(int i =m-2;i>=0;i--)
//        {
//            if(list[i].start>=list[i+1].start)
//            continue;
//            else
//            {
//                res+= (list[i].end -  list[i].start+1);
//            }
//        }
//
//return  res;
        return  minimumCoverInterval(list, new Interval(1, n));
    }






    static int minimumCoverInterval(Interval[] intervals, Interval target) {

        if (intervals == null || intervals.length == 0) return -1;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int total = 0;
        for (Interval i : intervals) {
            min = Math.min(min, i.start);
            max = Math.max(max, i.end);
        }
        int[] count = new int[max - min + 1];


        Interval it [] =   new Interval[max - min+1];

        for (Interval i : intervals) {
            if(count[i.start - min] >= i.end - i.start )
                continue;
            else
            {

                                count[i.start - min] =  i.end - i.start;
                                it[i.start-min] = i;

            }




//            count[i.start - min] = Math.max(count[i.start - min], i.end - i.start);
        }


        for(Interval iw :it)
            System.out.print(iw.start+"\t"+iw.end);
        System.out.println();

        for(int i: count)
            System.out.print(i+"\t");
        System.out.println();


        int reach = 0;
        int maxReach = 0;
        int target_start = target.start - min;
        int target_end = target.end - min;
        int i = 0;
        for (; i <= target_start; i++) {
            if (i + count[i] < target_start) continue;
            reach = Math.max(reach, i + count[i]);
        }

        int res = 1;

        for (; i < count.length; i++) {
            if (reach >= target_end)
            {
                System.out.println("TOTAL : "+total);
                break;}
            maxReach = Math.max(maxReach, i + count[i]);

            if (reach <= i) {

                total+=(it[i].end -  it[i].start);

                System.out.println("Reach "+reach+"\t max reach "+maxReach);
//                t/otal+=(maxReach-reach);
                reach = maxReach;
//                total++;
                res++;


            }
        }

        System.out.println("Total :"+total);
        return reach >= target_end ? res : -1;
    }








}



class Interval{
    int start, end;
    Interval (int s, int e)
    {
        this.start = s;
        this.end = e;

    }

}
