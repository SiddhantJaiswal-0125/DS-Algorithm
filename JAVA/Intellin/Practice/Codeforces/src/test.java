import java.util.HashMap;
import java.util.*;
class test
{
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n =sc.nextInt();
            int days = sc.nextInt();
            int com[] = new int[n];
            for(int i =0;i<n;i++)
                com[i] = sc.nextInt();

        System.out.println(findMinComplexity(com,days));


    }
    static  int findMinComplexity(int comlexity[], int days)
    {
        int total = 0;
        int max =  -1;
        for(int i : comlexity)
            max = Math.max(i, max);
        int size =  comlexity.length;
        int i = 0, j = size-1;
        while(days>1)
        {
            if(comlexity[i]>comlexity[j])
            {
                total += comlexity[j];
                j--;
            }
            else
            { total += comlexity[i];

                i++;
            }
            days--;

        }
        total+=max;

        return total;



    }
//    int  func(int a, int b);

}