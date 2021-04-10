import java.util.Scanner;

public class KnaivePatternSearching
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String txt = sc.next();
        String pat = sc.next();
        search(txt,pat);

    }
    static  void search (String txt , String pat)
    {
        int n = txt.length();
        int m = pat.length();
        boolean matches = true;
        for(int i =0;i<=n-m;i++)
        {
            matches = true;
            for(int j = 0;j<m && matches;j++)
            {
                if(txt.charAt(i+j)!=pat.charAt(j))
                {

                    matches = false;

                }
                else
                {
//                    System.out.println("equal at i "+i);

                }
            }
            if (matches)
                System.out.println(i+1);

        }
    }
}
