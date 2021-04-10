import java.util.*;
public class Minimumnumberofjumps 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]  = new int[n];
        for(int i =0;i<n;i++)
        a[i] = sc.nextInt();
        int i =0;
        int min = Integer.MAX_VALUE;
        int ind = -1;
        int count =0;
        while(i<n)
        {
            int k = a[i];
            int o = i;
            while(i<o+k)
            {
                if(i+a[i]<min)
               { 
                   min = i+a[i];
                   ind = i;
                }
                count++;
             i++;   
            }
         i = ind;



        }
        System.out.println(count);

        sc.close();
    }
    
}
