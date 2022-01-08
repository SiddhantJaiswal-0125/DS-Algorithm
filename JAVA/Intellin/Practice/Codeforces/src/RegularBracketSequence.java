import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

public class RegularBracketSequence
{
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int test =  sc.nextInt();
        while(test-->0)
        {
            String s = sc.next();
            if (findans(s))
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
    static  boolean findans(String s)
    {
        int size = s.length();

        if(s.charAt(0)==')'|| s.charAt(size-1)=='(')
            return  false;
        int cnt = 0;
        for(int i = 0;i<size;i++)
            if(s.charAt(i)=='?')
                cnt++;

        if(cnt%2==0)
            return true;
        else
            return false;

    }
}
