import java.util.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class evenoddGame
{
    public static void main(String[] args) throws  IOException
    {
        Reader sc = new Reader();
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            long a[] = new long[n];

            ArrayList<Long>  even = new ArrayList<>();
            ArrayList <Long> odd = new ArrayList<>();

            for(int i = 0;i<n;i++) {
                a[i] = sc.nextInt();
            if(a[i]%2==0)
                even.add(a[i]);
            else
                odd.add(a[i]);
            }
            Collections.sort(even);
            Collections.sort(odd);

//            Arrays.sort(a);
            long sumA = 0l;
            long sumB = 0l;
            boolean start = true;

            int sizeEven = even.size()-1;
            int sizeOdd = odd.size()-1;
//            for(int i = 0;i<=sizeEven;i++)
//                System.out.print(even.get(i)+" ");
//            System.out.println();
//
//            for(int i = 0;i<=sizeOdd;i++)
//                System.out.print(odd.get(i)+" ");
//            System.out.println();

            while(sizeEven>=0 || sizeOdd>=0)
            {

                if (start) {
                    if(sizeEven>=0)
                    {
                        if(sizeOdd>=0)
                        {
                            if (even.get(sizeEven) > odd.get(sizeOdd))
                            {
                                sumA += even.get(sizeEven);
                                sizeEven--;
                            }
                            else
                                sizeOdd--;
                        }
                        else
                        {
                            sumA += even.get(sizeEven);
                            sizeEven--;
                        }

                    }
                    else
                       sizeOdd--;


                    start = false;
                }
                else {
                    if(sizeOdd>=0)
                    {
                        if(sizeEven>=0)
                        {
                            if(odd.get(sizeOdd)>even.get(sizeEven))
                            {
                                sumB+=odd.get(sizeOdd);
                                sizeOdd--;
                            }
                            else
                                sizeEven--;
                        }
                        else
                        {
                            sumB+=odd.get(sizeOdd);
                            sizeOdd--;
                        }
                    }
                    else
                        sizeEven--;

                    start = true;
                }
            }


//            System.out.println("SUM A "+sumA);
//            System.out.println("SUM B "+sumB);

            if(sumA>sumB)
                System.out.println("Alice");
            else if(sumA<sumB)
                System.out.println("Bob");
            else
                System.out.println("Tie");

        }
    }
    static class Reader {
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
            } while ((c = read()) >= '0' &&c <= '9');
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
            while ((c = read()) >= '0' &&c <= '9');
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
            while ((c = read()) >= '0' &&c <= '9');
            if (c == '.')
            {
                while ((c = read()) >= '0' &&c <= '9')
                {
                    ret += (c - '0') /(div *= 10);
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
