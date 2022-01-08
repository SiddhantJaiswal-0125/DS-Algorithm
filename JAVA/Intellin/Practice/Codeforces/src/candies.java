import java.util.Scanner;

public class candies
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ar[] = solve(n,k);
        for(int i  =0;i<k;i++)
            System.out.print(ar[i] +"\t");
        System.out.println();
    }


    static int []  solve(int n , int k)
    {
        int res[] = new int[k];
        int ind = 1;
        int count = 0;

        System.out.println("HERE");

        while(n>0)
        {
            int l = (ind-1)*k;
            int r =  ind * k;

            int sl = l * (l+1) /2;
            int sr = r * (r+1) / 2;
            int dif = sr - sl;
            if(dif<=n)
            {
                count++;
                ind++;
                n-=dif;
            }
            else
            {
                int term = ((ind - 1) * k )+1;

                int i = 0;

                while(n>0){
                if(term<=n)
                {
                    res[i++] = term;
                    n-=term;
                    term++;

                }
                else {
                    res[i++] = n;
                    n = 0;
                }
                }

            }
          }


        for(int j =0;j<k;j++)
        {
            res[j] += (  (count * (j + 1)) + ((count -1)*k*count)/2 );
        }














        return res;
    }






}
