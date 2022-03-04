import java.util.Scanner;

public class oddEven {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        int ans = new oddEven().countOdds2(low, high);
        System.out.println(ans);
    }
    public int countOdds(int low, int high) {
        int dif = high - low;
        if((dif + 1 )% 2 == 0)
            return dif/2 + 1;
        else
        {
            if(low%2==0)
            {
                return dif /2;
            }
            else
                return dif/2 + 1;

        }



    }
    public int countOdds2(int low, int high) {
        int dif = high - low;
        if((dif + 1 % 2) == 0) {
            System.out.println("HERe");
            return dif / 2 + 1;
        }else
        {
            if(low%2==0)
            {
                return dif /2;
            }
            else
                return dif/2 + 1;

        }



    }
}
