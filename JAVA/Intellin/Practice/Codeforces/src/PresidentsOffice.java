import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class PresidentsOffice 
{

    static FastReader sc = new FastReader();
    static void print(char a[][], int n , int m )
    {
        for(int i =0;i<n;i++)
       {for(int j = 0;j<m;j++)
        System.out.print(a[i][j]+" ");
        System.out.println();
    }
    }
        public static void main(String[] args)
        {
            
            int n = sc.nextInt();
            int m = sc.nextInt();
            char c = sc.next().charAt(0);
            int find = solve(n,m,c); 
            System.out.println(find);           
        }
        static int solve(int n , int m , char c)
        {
            HashSet <Character> hs = new HashSet<>();
            
            char a[][] = new  char[n][m];
            for(int i =0;i<n;i++)
            {
                String s = sc.next();
                
                for(int j =0;j<m;j++)
                {
                    a[i][j]  = s.charAt(j);
                        

                }
            }
            for(int i =0;i<n;i++)
            {
                for(int j =0;j<m;j++)
                {
                        if(a[i][j]==c)
                        {
                            
                            if(j>0 && a[i][j-1]!= c && a[i][j-1]!= '.' )
                            {
                                 hs.add(a[i][j-1]);
                            }
                            if(j<m-1 && a[i][j+1]!= c && a[i][j+1]!= '.' )
                            {
                                 hs.add(a[i][j+1]);
                            }

                            if(i>0 && a[i-1][j]!= c && a[i-1][j]!= '.' )
                            {
                                 hs.add(a[i-1][j]);
                            }
                            if(i<n-1 && a[i+1][j]!= c && a[i+1][j]!= '.' )
                            {
                                 hs.add(a[i+1][j]);
                            }
                                
                        }
                     }
            }








            return hs.size();
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
                catch (IOException e)
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


