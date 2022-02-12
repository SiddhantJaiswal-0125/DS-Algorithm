import java.util.Scanner;

public class FloweredBed {
    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        int size = flowerbed.length;




        for(   int i = 0;i<size;)
        {
            System.out.println("AT ITERATION "+i+" n is : "+n);
            if(n<=0) {

                    System.out.println("HERE INSIDE");
                    return true;

                }
                if(flowerbed[i]==1)
                i+=2;
            else{

                if(i+1 < size)
                {
                    if(flowerbed[i+1]!=1)
                    {    n--;
                        i+=2;
                    }
                    else
                        i++;
                }
                else
                {
                    System.out.println("AT ITER : "+i);
                    n--;

                    i+=2;
                }
            }




        }




        System.out.println("HERE TRuE");

        return n <=0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i= 0;i<n;i++)
            a[i] =sc.nextInt();
        int k = sc.nextInt();

        System.out.println(canPlaceFlowers(a,k));
    }
}
