import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ANewTechnique {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int table[][] = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {

                    table[i][j] = sc.nextInt();

                }
            }
            String s;
            int a[] = new int[n];
            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    for (int j = 0; j < n; j++) {
                        a[j] = sc.nextInt();
                    }
                }
                else
                    s = sc.nextLine();

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[j][0] == a[i]) {
                        //swap
//                        System.out.println("GOT ELEMENT");
                        int temp[] = table[i];
                        table[i] = table[j];
                        table[j] = temp;
                        for (int q = 0; q < m; q++) {
                            System.out.print(table[i][q] + " ");
                        }
                        System.out.println();


                    }

                    }



            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(table[i][j] + " ");
//                }
//                System.out.println();
//            }


        }
    }


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}