import java.util.*;class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        int m = sc.nextInt();
        Arrays.sort(a);
        System.out.println(n);
        for(long i : a)
            System.out.print(i+" ");

        System.out.println();
//        for(int i = 0;i<n;i++)
//            System.out.print(i+" ");
//        System.out.println();
        System.out.println(m);
        sc.close();
    }
}
