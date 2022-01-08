import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HillsAndValleys
{
    public static void main(String[] args) throws  IOException {
        Reader sc = new Reader();
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            long a[] = new long[n];
            for(int i =0;i<n;i++)
            {
                a[i] = sc.nextLong();
            }
            int H_OR_V[] = new int[n];
//            2 for hill
//            1 for valley
            if(n<=3)
                System.out.println(0);
            else
                {
                    int cnt = 0;
                    for(int  i =1;i<n-1;i++)
                    {
                        if(a[i]>a[i+1] && a[i]>a[i-1])
                        {
                            H_OR_V[i] = 2;
                        cnt++;
                        }else if(a[i]<a[i+1] && a[i]<a[i-1])
                        {H_OR_V[i] = 1;
                        cnt++;
                        }
                    }

                    int MaxContinous = 0;
                    int cont = 0;
                    for (int i = 1; i < n - 1; i++) {
                        if (H_OR_V[i] == 1) {
                            if (H_OR_V[i - 1] == 2 && H_OR_V[i + 1] == 2) {
//                                a[i] = a[i - 1];
                                cont++;

                            }
                        } else if (H_OR_V[i] == 2) {
                            if (H_OR_V[i - 1] == 1 && H_OR_V[i + 1] == 1) {
//                                a[i] = a[i - 1];
                             cont++;
                            }
                        }
                        else
                        {
                            if(cont>MaxContinous)
                                MaxContinous = cont;

                        }
                    }
                    if(cnt==0)
                        System.out.println(0);
                    else
                    {
                        if(MaxContinous>1)
                            System.out.println(cnt-2);
                        else
                            System.out.println(cnt-1);
                    }

                }
    }
}
}

class Reader {
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

