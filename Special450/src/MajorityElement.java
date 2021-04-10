import java.util.Scanner;

public class MajorityElement
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int  i =0;i<n;i++)
                a[i]= sc.nextInt();

            printAns(a,n);
        }
    }
    static void printAns(int a[], int n)
    {

        int  candidate = findCandidate(a,n);

        if(isValid(candidate,a,n))
            System.out.println(candidate);
        else
            System.out.println(-1);
    }


    static int findCandidate(int a[], int n)
    {

        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < n; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];}
    static  boolean isValid(int candidate, int a[], int n)
    {
        int limit = n/2;
        int count =0;
        for(int  i =0;i<n;i++)
            if(a[i]==candidate)
                count++;




        if(count>n/2)
            return  true;
        else return false;



    }
}
