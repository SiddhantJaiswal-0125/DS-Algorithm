import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();

        System.out.println(new test().solution(ar));
    }
  public int solution(int [] A)
  {
      int n = A.length;
      int sum = 0;
      boolean isneg = true;

      int max = 0;

      for(int i =0;i<n;i++)
      {
          if(A[i] >=0)
          {
              isneg = false;
              sum+=A[i];
              if(sum>max)
                  max = sum;
          }
          else
              sum= 0;


      }
      if(sum>max)
          max = sum;


      if(isneg)return -1;
      return max    ;

  }
}
