import java.util.Scanner;

public class PuttingBricksintheWall
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int  n = sc.nextInt();
            char[][]c = new char[n][n];
            for(int i = 0;i<n;i++)
            {
                String a = sc.next();
                for(int j = 0;j<n;j++)
                {
                    c[i][j]  =a.charAt(j);
                }
            }
            char sC = c[0][1];
            char sR = c[1][0];
            char eL , eR;
            eL = c[n-1][n-2];
            eR = c[n-2][n-1];
            if(sC == sR)
            {
                if(eL == eR)
                {
                    if(eL!=sC)
                        System.out.println(0);
                    else
                        {
                            System.out.println(2);
                            System.out.println((n-1)+" "+(n));
                            System.out.println((n)+" "+(n-1));


                        }
                }
                else if (eL == sC)
                {
                    //a==b and c = a = b;

                    System.out.println(1);
                    //location of E L
                    System.out.println(n+" "+(n-1));


                }
                else if(eR == sC)
                {
                    //a==b and d = a = c
                    System.out.println(1);
                    System.out.println(n-1+ " " +n);
                }

            }
            else if (eL == eR)
            {
                if(sC == eR)
                {
                    //c==d and a==c==d
                    System.out.println(1);
                    System.out.println(1+" "+2);

                }
                else if(sR == eR) {
                    //c==d and b==c==d
                    System.out.println(1);
                    System.out.println(2+" "+1);
                }
            }
            else if(eL==sC)
            {
                System.out.println(2);
                System.out.println((n-1)+" "+n);
                System.out.println(1+" "+2);

            }
            else if(eL == sR)
            {

                System.out.println(2);
                System.out.println(n+" "+(n-1));
                System.out.println(1+" "+2);

            }

        }
    }



}
