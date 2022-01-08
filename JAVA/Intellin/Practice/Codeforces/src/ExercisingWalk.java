import java.util.Scanner;

public class ExercisingWalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();


            if (solve(a,b,c,d,x,y,x1,y1,x2,y2))
                System.out.println("Yes");
            else
                System.out.println("No");


        }

    }

    static boolean solve(int a,int b,int c ,int d,long x,long y,long x1,long y1,long x2,long y2)
    {
        long finalX = x;
        long finalY = y;
        if(a>0)
        {
            if(b>0)
            {
                if(x+1>x2 && x-1<x1)
                    return  false;
            }
        }

        if(c>0)
        {
            if(d>0)
            {
                if(y+1>y2 && y-1 <y1)
                    return  false;

            }

        }


        if(a!=b)
        {
            if(a>b)
            {
                finalX = x-(a-b);




            }
            else
            {
                finalX = x + (b-a);

            }

        }

        if(c!=d)
        {
            if(c>d)
            {
                finalY = y-(c-d);

            }
            else
            {
                finalY = y+(d-c);
            }

        }

        if((finalX < x1 || finalX >x2) || (finalY < y1 || finalY > y2))
            return  false;


        return  true;
    }
}
