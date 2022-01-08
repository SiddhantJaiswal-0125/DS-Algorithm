import java.util.Locale;
import java.util.Scanner;

public class SuitandTie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ar[] = new int[2*n];
//        for(int i  =0;i<2*n;i++)
//            ar[i] = sc.nextInt();
//        int ans =  solve(ar,n);
        String res = sc.next();
    }


    static int solve(int ar[], int size)
    {
        int ans = 0;
        for(int i = 1, j;i<2*size;i+=2)
        {
            for(j = i;j<2*size;j++)
                if(ar[j]==ar[i-1])
                    break;
              for(;j>i;j--)
              {
                  int temp = ar[j];
                  ar[j] = ar[j-1];
                  ar[j-1] = temp;
                  ans++;
              }
        }
        return ans;
    }
}
