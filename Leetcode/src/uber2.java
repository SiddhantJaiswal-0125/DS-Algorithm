import java.util.*;
public class uber2 {
  public  static int canPass2(int N, int []arr)
    {
        int step =  1;
        for(int i = 1;i<N;i++)
        {
            if(step<0)
                return 0;
            int dif = arr[i] - arr[i-1];
            if(dif == step ) {
                continue;
            }
            else if(dif ==  step-1)
                step = step-1;
            else if(dif ==step+1)
                step = step+1;
            else
                return 0;
        }
        return 1;
    }          
    public  static int canPass(int N, int []arr)
    {
        int step =  1;
        for(int i = 0;i<N;i++)
        {
            if(step<0)
                return 0;
            int dif = 0;
            if(i==0)
                dif = arr[0] - 1;
            else
                dif = arr[i] - arr[i-1];

            if(dif == step )
                continue;
            else if(dif ==  step-1)
                step = step-1;
            else if(dif ==step+1)
                step = step         +1;
            else
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int [n];
        for(int i =0 ;i<n;i++)
            ar[i] = sc.nextInt();

        int ans = canPass(n,ar);
        System.out.println(ans);
    }
}
