import java.util.HashSet;
import java.util.Scanner;

public class SinglePush
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int a[] = new int [n];
            int b[] = new int[n];
            for(int i =0;i<n;i++)
            {
                a[i] = sc.nextInt();

            }
            HashSet <Integer>  hs = new HashSet<Integer>();
            boolean containsgreater = false;
            int start =-1;
            int end = -1;

            for(int i =0;i<n;i++)
            {
                b[i] = sc.nextInt();
            }
            int dif = 0;
            int ind = 0;
            for(int i =0;i<n;i++)
            {
                if(b[i]-a[i]>0)
                {
                    if(start==-1) {
                        start = i;
                    dif = b[i] - a[i];
                    a[i] = b[i];

                    }
                    else
                    {
                        if(a[i]!=b[i])
                        {
                            a[i]+=dif;

                        }
                        else
                        {
                            end = i;
                            break;

                        }
                    }
                }
                else if (a[i]==b[i] && start!=-1)
                    break;

                else if(b[i]<a[i])
                    containsgreater = true;


            }

            for(int i =0;i<n;i++)
                if(a[i]!=b[i])
                    containsgreater = true;
            if(containsgreater)
                System.out.println("NO");
            else
                System.out.println("YES");




        }

    }
}

//3
//        1 2 3
//        2 2 4