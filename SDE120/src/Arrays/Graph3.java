package Arrays;

//https://code.sec.samsung.net/


import java.util.*;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Graph3 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc = new Scanner(System.in);

        int v, e, st, en;
        v = sc.nextInt();
        e = sc.nextInt();

        int[][] edg = new int[v][v];

        for (int i = 0; i < e; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();

            edg[a][b] = 1;
            edg[b][a] = 1;

        }

        boolean[] vis = new boolean[v];

        st = sc.nextInt();
        en = sc.nextInt();


        System.out.println(solve(edg, v, st, en, vis));
    }

    private static boolean solve(int[][] edg, int v, int st, int en, boolean[] vis) {



        if (v == 0)
            return false;

        vis[st] = true;

        if (st == en) {
            return true;
        }



        for (int i = 0; i < v; i++) {
            if (i == st)
                continue;



            if (vis[i]==false && edg[st][i] == 1) {
                if(i==en) {
                    return true;
                }

                return solve(edg, v, i, en, vis);
            }
        }
        vis[st] = false;

        return false;
    }

}










