import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class ATWNT
{
    static int dp[];
    public static void main(String[] args) throws  IOException
    {
        Reader sc =  new Reader();
        int n = sc.nextInt();
//        ArrayList <Integer> node[]  = new ArrayList<Integer>()[n+1];
        NODE node[]  = new NODE[n+1];


        for(int i =0;i<n+1;i++)
        {
            node[i] = new NODE();
            node[i].node = new ArrayList<>();
        }int p[]  = new int[n+1];
        for(int i=2;i<=n;i++)
        {
            p[i] = sc.nextInt();
            node[p[i]].node.add(i);
        }
        int q = sc.nextInt();
        while(q-->0)
        {
            dp = new int[n+5];
//            Arrays.fill(dp,-1);
            int v = sc.nextInt();
            int w = sc.nextInt();
            int ans = solve(v,w,node);
            System.out.println(ans);
        }
    }



    static int solve(int v, int w , NODE n[])
    {
        int k = n[v].node.size();
        if(k>0)
        {
            if(w%k==0)
            {
                int ans = 0;
                if(dp[v]!=0)
                    return  dp[v];
                else{
                for(int childver : n[v].node)
                {
                    ans +=solve(childver, w/k,n);
                }
                dp[v] = ans;
                return  ans; }

            }
        else
            return w;
        }
        else
            return 0;





    }
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
class NODE
{
    ArrayList <Integer> node;

}