import java.util.Scanner;

public class DimaandContinuous
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();
        boolean res = solve(ar, n);
        if(res)
            System.out.println("yes");
        else
            System.out.println("no");
    }
    static boolean solve(int ar[], int n)
    {
//        if(alreadysorted(ar, n))
//        return  false;
//        else
//        {
            int points[][] = new int[n-1][2];
            for(int i =0;i<n-1;i++)
            {
                int min = Math.min(ar[i], ar[i+1]);
                int max = Math.max(ar[i], ar[i+1]);
                points[i][0] = min;
                points[i][1] = max;
            }


//        System.out.println("POINTS ARE " );
//            for(int i = 0;i<n-1;i++)
//                System.out.println(points[i][0]+"\t"+points[i][1]);


            for(int i  =0;i<n-1;i++)
            {
                int outx = points[i][0];
                int outy = points[i][1];
                for(int j = 0;j<n-1;j++)
                {
                    if(i==j)
                        continue;


                    if(outx<points[j][0]  && points[j][0] < outy)
                    {


                        if(points[j][1]>outy)
                        {

//                            System.out.println("FOR POINTS ");
//                            System.out.println(outx+"\t "+outy);
//                            System.out.println(points[j][0]+"\t"+ points[j][1]);
                            return  true;
                        }
                    }
                }
            }






//        }

        return false;


    }
    static boolean alreadysorted(int ar[], int n)
    {
        boolean b = true;

        if(n==1)
            return  true;

        for(int i = 1;i<n;i++)
            if(ar[i]>ar[i-1])
            {
                b = false;
                break;
            }


        if(b == false) {
            for (int i = 1; i < n; i++)
                if (ar[i] < ar[i - 1]) {
                    b = false;
                    break;
                }
        }

        return  b;

    }
}
