import java.util.ArrayList;
import java.util.Scanner;

public class spiral
{




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();



        while(test-->0)
        {
            int n = sc.nextInt();
            int x = 0, y = 0;
            char dir = 'r';
            ArrayList<Pair> ans = new ArrayList<>();
            int q = n;
            if(q>=1)
                ans.add(new Pair(0,0));
            q--;

            //four different ranges
            int rr = 1, lr = -1, tr = 1, dr = -1;

            int vi =0, hi =0;
            //vertical and horizontal  index
            while(q>0)
            {
                if(dir=='r')
                {
                    //
//                    x++;
                    while(hi<rr && q>0)
                    {
                        x++;


//                        System.out.println("RIGHT");
                        ans.add(new Pair(x, y));

                        hi++;
                        q--;
                    }

                    rr++;
                    dir='d';

                }
                else if(dir=='d')
                {
//                    y--;
                    while(vi>dr && q>0)
                    {
//                        System.out.println("DOWN");

                        y--;
                          ans.add(new Pair(x, y));
                      vi--;

                        q--;
                    }
                    dr--;


                    dir = 'l';

                }

                else if(dir == 'l'  )
                {
                    //
                    while(hi>lr && q>0)
                    {

//                        System.out.println("LEFT");

                        x--;
                        ans.add(new Pair(x, y));
                            q--;
                            hi--;

                    }
                    lr--;
                    dir = 'u';
                }
                else if(dir == 'u')
                {

                    while(vi<tr && q>0)
                    {
//                        System.out.println("UP");
                        y++;
                        ans.add(new Pair(x, y));
                        q--;
                        vi++;

                    }
                    tr++;

                    dir = 'r';
                }
            }


            System.out.println("PRINTING THE TRAVERSAL");
            for(Pair p : ans)
                System.out.print(p.x +" "+p.y+", \t");
            System.out.println();
        }

    }
    static class Pair
    {
        int x, y;
        Pair(int x, int y)
        {
            this.x =x;
            this.y = y;

        }
    }
}
