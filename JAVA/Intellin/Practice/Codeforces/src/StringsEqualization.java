import java.util.Scanner;
import java.util.HashSet;
public class StringsEqualization
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test =  sc.nextInt();
        while(test-->0)
        {

            String a = sc.next();
            String b = sc.next();
            if(check(a,b))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static boolean check(String a, String b)
    {
        int n = a.length();
        HashSet<Character> hs = new HashSet<Character>();
        for(int i  =0;i<n;i++)
            hs.add(a.charAt(i));

        for(int i=0;i<n;i++)
            if(hs.contains(b.charAt(i)))
                return true;




        return false;
    }
}
