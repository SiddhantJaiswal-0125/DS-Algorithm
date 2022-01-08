import java.util.Scanner;

public class UniversalSolution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {
            String bot = sc.next();
            int r =0,p=0,s=0;
            int n = bot.length();
            for(int i =0;i<n;i++)
            {
                char c = bot.charAt(i);

                if(c=='R')
                {
                    r++;
                }
                else if(c=='P')
                {
                    p++;
                }
                else if(c=='S')
                {
                    s++;
                }

            }
            solve(r,s,p,bot,n);


        }
    }
    static  void solve(int r, int s , int p , String bot, int n)
    {

        if(r>=s && r>=p)
            print('P',n);
        else if(p>=s && p >= r)
        print('S',n);
        else if(s>=p && s>=r)
            print('R',n);


    }
    static void print(char ans , int n)
    {
        for(int i =0;i<n;i++)
            System.out.print(ans+"");
        System.out.println();
    }
}