import java.util.*;
public class TMTDocument {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int a = 1;
        while (test-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int noOfT = 0;
            int noOfM = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'T')
                    noOfT++;
                else
                    noOfM++;

            }

            if (noOfT != (2 * (int) (noOfM))) {
                System.out.println("NO");
            } else if (s.charAt(0) == 'M' || s.charAt(n - 1) == 'M')
                System.out.println("NO");
            else
                solve2(s, n);

        }

    }


    static void solve2(String s, int n) {
        boolean yes = true;
        int countT = 0, countM = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                countM++;

            } else
                countT++;
            if (countM > countT) {
                yes = false;
                break;
            }
        }
        if (yes) {
            countM = 0;
            countT = 0;
            for (int i = n - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == 'M') {
                    countM++;

                } else
                    countT++;
                if (countM > countT) {
                    yes = false;
                    break;
                }
            }


        }


        if (yes)
            System.out.println("YES");
        else
            System.out.println("NO");


    }
}
