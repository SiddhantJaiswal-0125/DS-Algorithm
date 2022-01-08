import java.util.Scanner;

public class Caninepoetry
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0)
        {
            solve();
        }
    }
    static void solve()
    {
        String in = sc.next();
        char c[] = in.toCharArray();

        int n = in.length();
        int ans = 0;
        if(n>1)
        {
            if(c[1]==c[0])
            {
                c[1] = '!';
                ans++;
            }

                for(int i =2;i<n;i++)
                {
                    if(c[i]==c[i-1])
                    {
                        c[i]='!';
                        ans++;

                    }
                    else if(c[i]==c[i-2])
                    {
                        ans++;
                        c[i]='!';
                    }

                }


        }

        System.out.println(ans);

    }
}
