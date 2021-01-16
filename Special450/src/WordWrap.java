import java.util.Scanner;

public class WordWrap
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int ch[] = new int[n];
            for(int i =0;i<n;i++)
            {
                ch[i] = sc.nextInt();
            }
            int limit = sc.nextInt();
            int ans[] = new int[(2*n)];
            int ind = 0;

            int valtillnow =0;

            for(int i = 0;i<n;i++)
            {
                if(ch[i]<=limit)
                {
                    if(limit-valtillnow-ch[i] >=0)
                    {
                        if(ind%2==0)
                        {




                        }
                        else
                        {



                        }
                    }
                    else
                    {
                        valtillnow = 0;
                        ans[ind++] = i+1;
                    }



                }

            }



        }
    }
}
