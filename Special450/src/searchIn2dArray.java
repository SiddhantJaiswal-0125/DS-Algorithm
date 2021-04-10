import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class searchIn2dArray {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] a = new char[n][m];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    a[i][j] = st1.nextToken().charAt(0);
                }
            }
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int count = -1;
            int indx = 0;
            int size = s.length();

//            int rowlen = a.length;
//            int collen = a[0].length;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    int k = solve(i, j, a, s, n, m, 0, size);
                    count+=k;
                    if (k > 0)
                        System.out.print(i + "" + j + ",");
                }
            if(count==-1)
                System.out.println(count);
            else
                System.out.println();
        }
    }
    static int solve(int i , int j , char a[][], String s , int rowlen , int collen,int indx, int size)
    {
        int found = 0;

        if(i>=0 && j>=0 && i<rowlen && j < collen && s.charAt(indx)==a[i][j])
        {
            char temp = s.charAt(indx);
            a[i][j] = '0';

            indx+=1;


            if(indx == size)
                found = 1;
            else
            {
                found += solve(i+1,j,a,s,rowlen,collen,indx,size);
                found += solve(i-1,j,a,s,rowlen,collen,indx,size);
                found += solve(i,j+1,a,s,rowlen,collen,indx,size);
                found += solve(i,j-1,a,s,rowlen,collen,indx,size);


            }
            a[i] [j] = temp;  // this for backtracking




        }






        return  found;
    }
}