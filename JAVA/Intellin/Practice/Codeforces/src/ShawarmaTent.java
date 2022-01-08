import java.util.Scanner;

public class ShawarmaTent
{
    static    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int n = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int t =0, l =0, r =0, d=0;
        while(n-->0)
        {
            int x = inint();
            int y = inint();
            if(x==sx)
            {
                if(y<sy)
                    d++;
                else
                    t++;
            }
            else if(y==sy)
            {
                if(x<sx)
                    l++;
                else
                    r++;
            }
            else if(x>sx && y>sy)
            {
                //1st quad
                r++;
                t++;
            }
            else if(x>sx && y<sy)
            {
                //4th quad
                r++;
                d++;
            }
            else if(x<sx && y>sy)
            {
                //2nd quad
                l++;
                t++;
            }
            else if(x<sx && y<sy)
            {

                //3rd quad
               l++;
               d++;
            }



        }

        if(t>=r && t>=l && t>=d)
        {
            System.out.println(t);
            System.out.println(sx+" "+(sy+1));
        }
        else if(d>=t && d>=l && d>=r)
        {
            System.out.println(d);
            System.out.println(sx+" "+(sy-1));

        }
        else if(l>=t && l>=d && l>=r)
        {
            System.out.println(l);
            System.out.println(sx-1+" "+(sy));

        }
        else if(r>=t && r>=d && r>=l)
        {
            System.out.println(r);
            System.out.println(sx+1+" "+(sy));


        }


    }
    static  int inint()
    {
        return sc.nextInt();
    }
}
