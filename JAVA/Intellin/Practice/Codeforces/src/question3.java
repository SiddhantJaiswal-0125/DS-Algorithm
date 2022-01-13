import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class question3 {
    static int solve(int []arr, int n)
    {
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(arr);
        q.add(arr[0]);
        for (int i = 1; i < n; i++)
        {
            int now = q.element();
            if (arr[i] >= 2 * now)
                q.remove();
            q.add(arr[i]);
        }
        return q.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i  = 0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = solve(ar, n);
        System.out.println(ans);

    }
}
