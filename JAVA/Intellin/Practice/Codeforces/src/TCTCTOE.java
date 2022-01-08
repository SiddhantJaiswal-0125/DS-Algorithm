import java.util.*;
import java.io.*;
 class TCTCTOE
{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while (test-->0)
        {
            char board [][] = new char[3][3];

            int cx =0, co =0,cdash=0;
            for(int i=0;i<3;i++)
            {
                String s = sc.next();
                for(int j =0;j<3;j++) {
                    board[i][j] = s.charAt(j);
                        if(board[i][j]=='X')
                            cx++;
                        else if(board[i][j]=='O')
                            co++;
                        else if(board[i][j]=='_')
                            cdash++;

                }
            }
            int wx = 0, wo = 0;
            //check for the rows
            for(int i =0;i<3;i++)
            {
                if(board[i][0]==board[i][1] && board[i][1]==board[i][2])
                {
                    if(board[i][0] =='X')
                        wx++;
                    else if(board[i][0] =='O')
                        wo++;
                }
            }
            //columns
            for(int i =0;i<3;i++)
            {
                if(board[0][i]==board[1][i] && board[1][i]==board[2][i])
                {
                    if(board[0][i] =='X')
                        wx++;
                    else if(board[0][i] =='O')
                        wo++;
                }
            }


            if(board[0][0]==board[1][1] && board[1][1]==board[2][2])
            {
                if(board[1][1] =='X')
                    wx++;
                else if(board[1][1] =='O')
                    wo++;

            }
            if(board[2][0]==board[1][1] && board[1][1]==board[0][2])
            {
                if(board[1][1] =='X')
                    wx++;
                else if(board[1][1] =='O')
                    wo++;

            }

            int ans = solve(cx,co,cdash,wx,wo);
            System.out.println(ans);
        }
    }
    static  int solve(int cx, int co, int cdash, int wx ,int wo)
    {
        if(co>cx || cx-co>1)
            return 3;
        else if(cx>co && wx==1 && wo==0)
            return 1;
        else if( cx==co && wo==1 && wx==0)
            return  1;
        else if(cdash==0  && wx==0 && wo==0)
            return 1;
        else if(cdash==0 && wx ==2)
            return 1;
        else if(cdash> 0 && wx ==0 && wo==0)
            return 2;
        else return  3;

    }



















    //fast reader
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



