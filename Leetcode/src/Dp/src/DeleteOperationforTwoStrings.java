import java.util.Scanner;

public class DeleteOperationforTwoStrings
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String st2 = sc.next();


        System.out.println(new DeleteOperationforTwoStrings().minDistance(st, st2));

    }
    public int minDistance(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    T[i][j] = T[i - 1][j - 1] + 1;
                else
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);


        int mx = T[m][n];
        int total = m - mx;
        total += n-mx;
        return total;
    }

}
