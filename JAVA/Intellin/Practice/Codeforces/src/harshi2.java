import java.util.*;

public class harshi2 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i]  = sc.nextInt();
        int k = sc.nextInt();

        int ans =  sol(ar, n , k);
        System.out.println(ans);
    }
    static int sol(int arr[], int n, int k)
    {
        int res =Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                int count = 1;
                for (int j = i + 1; j < n; j++)
                    if (arr[i] == arr[j])
                        count += 1;
                    if (count == k)
                    res = Math.min(res, arr[i]);
            }
        }
        return res;
    }
}
