import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

 class BLKJK
{
    public static void main(String[] args)  throws  IOException
    {
     Reader sc = new Reader();
     int test = sc.nextInt();
     while(test-->0)
     {
         int n,x,y;
         n = sc.nextInt();
         x = sc.nextInt();
         y = sc.nextInt();
         int a[] = new int[n];
         long sum =0l;
         boolean all = true;
         boolean got = false;
         boolean anyif = false;
         for(int i =0; i<n;i++)
         {
             a[i] = sc.nextInt();

             if(all&&a[i]<=y)
                 all = false;
             sum    +=a[i];
             if(sum>=x && sum<=y)
                 got =true;

             if(a[i]>=x && a[i]<=y)
             {
              anyif = true;
             }
         }
         if(!all || sum<x)
             System.out.println(-1);
         else if(got)
             System.out.println(0);
         else if(anyif)
             System.out.println(1);
         else
             solve(a,n,x,y);

     }

    }
    static  void  solve(int a[],int n ,int x,int y)
    {
        long sum = 0l;
        int indx = 0;
        for(int i =0;i<n;i++)
        {
            sum+=a[i];
            indx = i;
            if(sum>x)
                break;
        }




    }
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
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

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}

