import java.util.Scanner;

public class Floor_Number
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int p =2,count =1;
            while(p<n)
            {
                count++;
                int j =1;
                while(j<=x)
                {
                    p++;
                    j++;
                }
                if(p>=n)
                    break;

            }
            System.out.println(count);
        }
    }
}
