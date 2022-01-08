import java.util.Scanner;

public class WizardofOrz
{
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int t = sc.nextInt();
        while   (t-->0)
        {
            int n = sc.nextInt();


            int ar[] = new int[n];
            int index = 0;
            if(n<=9)
            {
                index = n -1;
            }
            else
                index = 8;


            int dis = 9-index;


            if(n<=10)
            {
                String s = "";
                int k = 9-n+1;
                for(int i = 0;i<n;i++)
                {
                    s=k+""+s;
                    k++;
                }
                System.out.println(s);
            }

            else
                {
                    String s = "";
                    int k = 1;
                    for(int i = 0;i<9;i++)
                    {
                        s=k+""+s;
                        k++;
                    }
                   k = 2;

                    for (int i =0;i<n-9;i++)
                    {
                        s=s+""+k;
                        k++;
                        k=k%10;

                    }
                    System.out.println(s);



                }
        }
    }
}
