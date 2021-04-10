import java.util.Scanner;
//using kadane algorithm
public class Maximumdifferenceofzerosandoneinbinarystring 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));

        sc.close();
    }
    static int solve(String s )
    {
        int max =0;
        int cur =0;
        int n = s.length();
        for(int i =0;i<n;i++)
        {
           cur+= s.charAt(i)=='0'?1:-1;
           if(cur>max)
           max = cur;
           if(cur<0)
           cur =0;


        }
        return max==0?-1:max;
    }
    
}
