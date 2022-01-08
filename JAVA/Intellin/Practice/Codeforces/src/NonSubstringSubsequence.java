import java.util.Scanner;

public class NonSubstringSubsequence
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        int test = sc.nextInt();
        while   (test-->0)
        {
            int n = sc.nextInt();
            int  q = sc.nextInt();
            String s = sc.next();
            while(q-->0)
            {
                int l = sc.nextInt();
                int r = sc.nextInt();
                if(getAns(s,l,r,n))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }


        }
    }
    static  boolean getAns(String s , int l, int r,int n )
    {
        char start = s.charAt(l-1);
        for(int i = l-2;i>=0;i--)
        {
            if(s.charAt(i)==start)
                return true;
        }
        char end = s.charAt(r-1);
        for(int i=r;i<n;i++)
            if(s.charAt(i)==end)
                return true;



        return  false;
    }
}
