import java.util.Scanner;

public class FairDivision
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0) {
            int  n = sc.nextInt();
            int arr[] = new int[n];
            int sum = 0;
            for(int i = 0; i<n;i++)
            {
                arr[i] = sc.nextInt();
                sum+=arr[i];
            }


            if (sum % 2 != 0)
                System.out.println("NO");
            else {
                int k = (sum / 2);
                boolean t[][] = new boolean[n + 1][k + 1];
                for (int i = 0; i < n + 1; i++)
                    for (int j = 0; j < k + 1; j++) {
                        if (i == 0)
                            t[i][j] = false;
                        if (j == 0)
                            t[i][j] = true;
                    }
                for (int i = 1; i < n + 1; i++)
                    for (int j = 1; j < k + 1; j++) {
                        if (arr[i - 1] <= j) {
                            t[i][j] = (t[i - 1][j - arr[i - 1]] || t[i - 1][j]);
                        } else
                            t[i][j] = t[i - 1][j];
                    }
                if(t[n][k])
                    System.out.println("YES");
                else
                    System.out.println("NO");
//                System.out.println(t[n][k]);
            }
        }
    }
}
