
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();
        int q = sc.nextInt();
        while(q-->0)
        {
            int j = sc.nextInt();


            int count = 0;
            int power = 0;
            for(int i =0;i<n;i++)
            {
                if(ar[i]<j)
                {
                    count++;
                    power+=ar[i];
                }
            }
            System.out.println(count+" "+power);









        }


    }
}
