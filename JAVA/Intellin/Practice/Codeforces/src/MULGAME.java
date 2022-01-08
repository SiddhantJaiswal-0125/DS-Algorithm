import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

 class MULGAME
{
    public static void main(String[] args) throws  IOException
    {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++)
                a[i]  = sc.nextInt();
            int ans [] = new int[300000];
            HashMap<pairlr, Integer> map = new HashMap<pairlr, Integer>();

            for(int i =0;i<q;i++)
            {
                int l = sc.nextInt();
                int r = sc.nextInt();
                l-=1;
                r-=1;
                if(a[l]>m)
                    continue;

                else
                {
                    if(a[r]>m)
                    {
                        ans[a[l]]++;
                        ans[m+1]--;
                    }else if(a[r] <= m)
                    {
                        ans[a[l]]++;
                        pairlr  p= new pairlr();
                        p.l =a[l];
                        p.r = a[r];
                        int count = map.containsKey(p) ? map.get(p) : 0;
                        map.put(p, count + 1);
                    }

                }
            }


            for (Map.Entry<pairlr,Integer> entry : map.entrySet())
            {


                int i ,j,k;
                i = entry.getKey().l;
                j = entry.getKey().r;
                k = entry.getValue();
                ans[i+j] -= k;
                ans[j+2*i] += k;
                int check = j + 2*i;
                while(check+j <= m)
                {
                    check += j;
                    ans[check] -= k;
                    ans[check+i] += k;
                    check += i;
                }

            }
            int res = 0;
            for(int i=1;i<=m;i++)
            {
                ans[i] += ans[i-1];
                res = Math.max(res,ans[i]);
            }
            System.out.println(res);







        }
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
class pairlr
{
    int l, r;


}