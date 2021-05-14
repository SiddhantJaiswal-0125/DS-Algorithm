package PepCoding;
import java.io.*;
import java.util.*;
public class NoOfIslands {



        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int m = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[m][n];

            for (int i = 0; i < arr.length; i++) {
                String parts = br.readLine();
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
                }
            }

            // write your code here


            boolean vis[][] = new boolean[m][n];
            int islands = 0;
            for( int i =0;i<m;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    if(arr[i][j]==0&& !vis[i][j]){
                        islands++;
                        solve(arr, m,n ,vis,i,j);
                    }
                }
            }

            System.out.println(islands);

        }
        static void solve(int ar[][], int m , int n, boolean vis[][], int i , int j)
        {
            if(i<0 || j<0 || j>=n || i>=m)
                return ;
            if(vis[i][j] || ar[i][j]==1)
                return;


            vis[i][j] = true;
            //search everywhere
            solve(ar,m,n,vis,i+1,j);

            solve(ar,m,n,vis,i, j+1);
            solve(ar,m,n,vis,i,j-1);
            solve(ar,m,n,vis,i-1,j);
        }

    }
