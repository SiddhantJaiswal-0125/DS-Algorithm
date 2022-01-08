
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

public class Hackerrank1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
int a =3;
int b = 5;


        System.out.println(a);
        System.out.println(b);
//                int n = sc.nextInt();
//                int ar[] = new int[n];
//                for(int i = 0;i<n;i++)
//                    ar[i] = sc.nextInt();
//
//                solve(ar, n);
//        char c = sc.next().charAt(0);
//        _binary(c);

//        int size = sc.nextInt();
//        int a[] = new int[size];
//        for(int i =0;i<size;i++)
//            a[i] = sc.nextInt();
//        solve2(a);


//        System.out.println(add(2,3));

//        swap(2,3);
        solve(7,10);


    }
    static void _binary(char c)
    {
        int a = (int)c;
        Stack <Integer> st = new Stack<>();
        while(a>0)
        {
            if(a%2==0)
                st.push(0);
            else
                st.push(1);
            a/=2;
        }
        while(!st.isEmpty())
            System.out.print(st.pop()+"\t");
        System.out.println();

    }
    static  void solve2(int ar[])
    {

        int size = ar.length;
        int sum = (size*size+1)/2;
        int sum2 = 0;

        int i = 1,j = size-1;
        while(i<j)
        {
            sum2+= (ar[i]+ar[j]);
            i++;
            j--;
        }
        if(size%2==1)
        {
            sum2 += ar[j];
        }
        System.out.println(sum-sum2);
    }
    static int add(int a, int b)
    {
        if (b<=0)
            return a;
        while(b>0)
        {
            int temp =a ^ b;
            b = (a&b) << 1;
            a = temp;
        }
        return  a;

    }
    static void swap(int a , int b)
    {
        System.out.println(a+"\t"+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a+"\t"+b);
    }
    static int solve(int a, int b)
    {
        int xor = a^b;
        int count = 0;
        while(xor>0)
        {
            if(xor%2==1)
                count++;
            xor/=2;
        }
        System.out.println("COUNT "+count);
        return count;
    }





}
