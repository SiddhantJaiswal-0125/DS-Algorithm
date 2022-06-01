import java.util.*;

class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            int n = sc.nextInt(), m = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            solve(arr, 0, arr.length, temp, m, res);
            int ans = Integer.MIN_VALUE;

            for (int i: res) {
                ans = Math.max(ans, i);
            }
            System.out.println(ans);
        }
    }

    static void solve(int [] arr, int i, int n, ArrayList<Integer> temp, int m, ArrayList<Integer> res) {
        if (i == n) {
            int sum = 0;
            for (int e: temp) {
                sum += e;
            }
            res.add(sum%m);
            return;
        }
        solve(arr, i+1, n, temp, m, res);
        temp.add(arr[i]);
        solve(arr, i+1, n, temp, m, res);
    }
}