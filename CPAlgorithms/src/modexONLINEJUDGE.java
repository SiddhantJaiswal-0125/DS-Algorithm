import java.util.Scanner;

 class modexONLINEJUDGE
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(getans(x,y,m));

        }
        int end = sc.nextInt();
    }

    static  long getans(long x,long y,long m)
    {
        if(x==0)
            return  0;
        if(y==0)
            return  1;
        long res = 0l ;
        if(y%2==0)
        {
            res = getans(x,y/2,m);
            res = (res*res)%m;
        }
        else
        {
            res =  x%m;
            res = (res*getans(x,y-1,m)%m)%m;

        }
        return (long) (res+m)%m;
    }
}
