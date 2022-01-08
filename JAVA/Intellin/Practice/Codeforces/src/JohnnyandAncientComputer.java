import java.util.Scanner;

public class JohnnyandAncientComputer
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long big  =0l,small =0l;
            if(a==b)
                System.out.println(0);
            else
            {
                if(a>b)
                {
                    big = a;
                    small = b;
                }
                else
                {
                    big = b;
                    small = a;
                }
                int cnt = 0;
                while(big!=small&&(big%2==0) && big>0)
                {
                    big /=2;
                    cnt++;
                }


                if(big==small)
                {
                    int ans = 0;
                    if(cnt>2){

                        ans +=cnt/3;
                        cnt%=3;

                    };
                    if(cnt>1)
                    {
                        ans++;
                         cnt = 0;
                    }
                    if(cnt>0)
                        ans++;

                    System.out.println(ans);
                }
                else
                    System.out.println(-1);





            }
        }
    }
}
